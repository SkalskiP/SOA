package controllers;

import theater.dto.CustomerDTO;
import theater.dto.EventDTO;
import theater.dto.SeatDTO;
import theater.exceptions.NotEnoughFundsException;
import theater.exceptions.SeatNotAvailableException;
import theater.interfaces.remote.IRemoteCustomerManager;
import theater.interfaces.remote.IRemoteReservationManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SessionScoped
@ManagedBean(name = "mainController")
public class MainController  {

    private Boolean insufficientFunds;
    private String selectedCustomerId;
    private String selectedEventId;
    private Integer numberOfSelectedSeats;
    private Double totalPrice;
    private HashMap<String, Boolean> selectedSeats;

    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/CustomerManagerBean")
    private IRemoteCustomerManager customerManager;

    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/ReservationManagerBean")
    private IRemoteReservationManager reservationManager;

    public MainController() {
        this.numberOfSelectedSeats = 0;
        this.totalPrice = 0.0;
        this.selectedSeats = new HashMap<>();
    }

    // =================================================================================================================
    // CUSTOMERS
    // =================================================================================================================

    public ArrayList<CustomerDTO> getCustomers() {
        return customerManager.getAllCustomers();
    }

    public String getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(String selectedCustomerId) {
        if (this.selectedCustomerId != selectedCustomerId) {
            this.selectedCustomerId = selectedCustomerId;
            this.selectedEventId = null;
            this.selectedSeats = new HashMap<>();
            this.totalPrice = 0.0;
            this.numberOfSelectedSeats = 0;
        }
    }

    public CustomerDTO getSelectedCustomer() {
        if (this.selectedCustomerId != null) {
            return customerManager.getCustomerById(this.selectedCustomerId);
        }
        return null;
    }

    public Double getBalanceForSelectedCustomer() {
        if (this.selectedCustomerId != null) {
            return customerManager.getCustomerById(this.selectedCustomerId).getBalance();
        }
        return null;
    }

    public void setSelectedCustomer(CustomerDTO selectedCustomer) {
        this.selectedCustomerId = selectedCustomer.getId();
    }

    // =================================================================================================================
    // EVENTS
    // =================================================================================================================

    public ArrayList<EventDTO> getEvents() {
        return reservationManager.getAllEvents();
    }

    public String getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(String selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public EventDTO getSelectedEvent() {
        if (this.selectedEventId != null) {
            return reservationManager.getEventById(selectedEventId);
        }
        return null;
    }

    // =================================================================================================================
    // SEATS
    // =================================================================================================================

    public ArrayList<SeatDTO> getSeats() {
        if (this.selectedEventId != null) {
            return reservationManager.getEventById(selectedEventId).getSeats();
        }
        return null;
    }

    public HashMap<String, Boolean> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(HashMap<String, Boolean> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public Integer getNumberOfSelectedSeats() {
        if (numberOfSelectedSeats != null) {
            return numberOfSelectedSeats;
        } else {
            return 0;
        }

    }

    public void setNumberOfSelectedSeats(Integer numberOfSelectedSeats) {
        this.numberOfSelectedSeats = numberOfSelectedSeats;
    }

    public void handleChangeSeat() {
        Integer numberOfSelectedSeats = 0;
        Double totalPrice = 0.0;
        for (Map.Entry<String, Boolean> entry : selectedSeats.entrySet()) {
            String seatId = entry.getKey();
            Boolean isSelected = entry.getValue();
            if (isSelected) {
                numberOfSelectedSeats ++;
                totalPrice += this.reservationManager.getSeatPrice(this.getSelectedEvent(), this.reservationManager.getSeatById(this.getSelectedEvent(), seatId));
            }
        }
        this.numberOfSelectedSeats = numberOfSelectedSeats;
        this.totalPrice = totalPrice;
        this.insufficientFunds = this.totalPrice > this.getBalanceForSelectedCustomer();
        System.out.println("Selected: " + this.numberOfSelectedSeats.toString());
        System.out.println("Price: " + this.totalPrice.toString());
    }

    // =================================================================================================================
    // PRICE
    // =================================================================================================================

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getInsufficientFunds() {
        return insufficientFunds;
    }

    public void setInsufficientFunds(Boolean insufficientFunds) {
        this.insufficientFunds = insufficientFunds;
    }

// =================================================================================================================
    // DEBUG
    // =================================================================================================================

    public void handleChangeUser() {
        if (selectedCustomerId != null) {
            System.out.println("New selected user: " + this.getSelectedCustomer().toString());
        }
    }

    public void handleChangeEvent() {
        if (selectedEventId != null) {
            System.out.println("New selected event: " + this.getSelectedEvent().toString());
        }
    }

    // =================================================================================================================
    // SUBMIT
    // =================================================================================================================

    public void submit() {
        System.out.println("SUBMIT");

        ArrayList<SeatDTO> seats = new ArrayList<>();

        for (Map.Entry<String, Boolean> entry : selectedSeats.entrySet()) {
            String seatId = entry.getKey();
            Boolean isSelected = entry.getValue();
            if (isSelected) {
                seats.add(this.reservationManager.getSeatById(this.getSelectedEvent(), seatId));
            }
        }

        try {
            this.reservationManager.buyTickets(this.getSelectedEvent(), seats, this.getSelectedCustomer());
//            error = null;
        } catch (NotEnoughFundsException e) {
//            error = "NotEnoughFunds";
        } catch (SeatNotAvailableException e) {
//            error = "SeatNotAvailable";
        }

        this.numberOfSelectedSeats = 0;
        this.totalPrice = 0.0;
        this.selectedSeats = new HashMap<>();
    }
}
