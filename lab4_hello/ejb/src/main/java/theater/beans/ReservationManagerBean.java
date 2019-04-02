package theater.beans;

import theater.dao.EventDAO;
import theater.dto.CustomerDTO;
import theater.dto.EventDTO;
import theater.dto.SeatDTO;
import theater.exceptions.NotEnoughFundsException;
import theater.exceptions.SeatNotAvailableException;
import theater.interfaces.IReservationManager;
import theater.interfaces.remote.IRemoteReservationManager;

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
    public Integer getSeatPrice(EventDTO event, SeatDTO seat) {
        return null;
    }

    @Override
    public void buyTickets(EventDTO event, ArrayList<SeatDTO> seats, CustomerDTO customer) throws NotEnoughFundsException, SeatNotAvailableException {

    }

    @Override
    public ArrayList<EventDTO> getAllEvents() {
        return EventDAO.getInstance().getItems();
    }

    @Override
    public EventDTO getEventById(String eventId) {
        return EventDAO.getInstance().getItem(eventId);
    }
}
