package theater.beans;

import theater.dao.CustomerDAO;
import theater.dao.EventDAO;
import theater.dto.CustomerDTO;
import theater.dto.EventDTO;
import theater.dto.SeatDTO;
import theater.exceptions.NotEnoughFundsException;
import theater.exceptions.SeatNotAvailableException;
import theater.interfaces.IReservationManager;
import theater.interfaces.local.ILocalPaymentManager;
import theater.interfaces.remote.IRemoteReservationManager;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import java.util.ArrayList;

@Singleton
@Remote(IRemoteReservationManager.class)
public class ReservationManagerBean implements IReservationManager {

    @Override
    public ArrayList<SeatDTO> getSeatList(EventDTO event) {
        return event.getSeats();
    }

    @Override
    public Double getSeatPrice(EventDTO event, SeatDTO seat) {
        return event.getRowPricing().get(seat.getRow());
    }

    @Override
    public void buyTickets(EventDTO event, ArrayList<SeatDTO> seats, CustomerDTO customer) throws NotEnoughFundsException, SeatNotAvailableException {
        for (SeatDTO seat : seats) {
            executeTransaction(customer, getSeatPrice(event, seat));
            seat.setReserved(true);
            seat.setCustomerId(customer.getId());
            event.getSeats().stream()
                    .filter(s -> s.getId().equals(seat.getId()))
                    .findAny()
                    .ifPresent(s -> {
                        s.setReserved(seat.getReserved());
                        s.setCustomerId(seat.getCustomerId());
                    });
            EventDAO.getInstance().updateItem(event);
        }
    }

    private void executeTransaction(CustomerDTO customer, Double price) {
        customer.setBalance(customer.getBalance() - price);
        CustomerDAO.getInstance().updateItem(customer);
    }

    @Override
    public ArrayList<EventDTO> getAllEvents() {
        return EventDAO.getInstance().getItems();
    }

    @Override
    public EventDTO getEventById(String eventId) {
        return EventDAO.getInstance().getItem(eventId);
    }

    @Override
    public SeatDTO getSeatById(EventDTO event, String seatId) {
        return event.getSeats().stream()
            .filter(s -> s.getId().equals(seatId))
            .findAny()
            .orElse(null);
    }
}
