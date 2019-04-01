package theater.dto;

import java.io.Serializable;
import java.util.UUID;

public class SeatDTO implements Serializable {
    private String id;
    private Integer number;
    private Character row;
    private Boolean isReserved;
    private String customerId;

    public SeatDTO(Integer number, Character row) {
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.row = row;
        this.isReserved = false;
        this.customerId = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Character getRow() {
        return row;
    }

    public void setRow(Character row) {
        this.row = row;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return row.toString() + " " + number.toString();
    }
}
