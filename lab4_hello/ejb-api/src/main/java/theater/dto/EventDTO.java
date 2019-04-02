package theater.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class EventDTO implements Serializable {
    private String id;
    private String name;
    private LocalDateTime date;
    private Map<Character, Double> rowPricing;
    private ArrayList<SeatDTO> seats;

    public EventDTO(String name, LocalDateTime date, Map<Character, Double> rowPricing, ArrayList<SeatDTO> seats) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
        this.rowPricing = rowPricing;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Map<Character, Double> getRowPricing() {
        return rowPricing;
    }

    public void setRowPricing(Map<Character, Double> rowPricing) {
        this.rowPricing = rowPricing;
    }

    public ArrayList<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<SeatDTO> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
