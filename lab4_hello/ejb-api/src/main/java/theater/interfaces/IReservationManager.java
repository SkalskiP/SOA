package theater.interfaces;

import theater.dto.CustomerDTO;
import theater.dto.EventDTO;
import theater.dto.SeatDTO;
import theater.exceptions.NotEnoughFundsException;
import theater.exceptions.SeatNotAvailableException;

import javax.ejb.Lock;
import java.util.ArrayList;

public interface IReservationManager {
    ArrayList<SeatDTO> getSeatList(EventDTO event);

    @Lock
    Double getSeatPrice(EventDTO event, SeatDTO seat);

    @Lock
    void buyTickets(EventDTO event, ArrayList<SeatDTO> seats, CustomerDTO customer) throws NotEnoughFundsException, SeatNotAvailableException;

    @Lock
    EventDTO getEventById(String eventId);

    @Lock
    SeatDTO getSeatById(EventDTO event, String seatId);

    ArrayList<EventDTO> getAllEvents();
}
