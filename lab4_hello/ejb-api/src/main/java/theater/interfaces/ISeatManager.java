package theater.interfaces;

import theater.dto.EventDTO;
import theater.dto.SeatDTO;

import javax.ejb.Lock;
import java.util.ArrayList;

public interface ISeatManager {
    @Lock
    boolean checkSeatAvailability(Integer eventId, SeatDTO seat);

    ArrayList<SeatDTO> getSelectedSeats();

    void selectSeat(SeatDTO seat);

    void unselectSeat(SeatDTO seat);

    void endSession();

    Double getTotalPrice(EventDTO event);
}
