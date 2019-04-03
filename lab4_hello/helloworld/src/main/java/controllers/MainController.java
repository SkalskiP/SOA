package controllers;

import theater.dto.CustomerDTO;
import theater.dto.EventDTO;
import theater.dto.SeatDTO;
import theater.interfaces.remote.IRemoteCustomerManager;
import theater.interfaces.remote.IRemoteReservationManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;

@SessionScoped
@ManagedBean(name = "mainController")
public class MainController  {

    private String selectedCustomerId;
    private String selectedEventId;
    private HashMap<String, Boolean> selectedSeats = new HashMap<>();

    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/CustomerManagerBean")
    private IRemoteCustomerManager customerManager;

    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/ReservationManagerBean")
    private IRemoteReservationManager reservationManager;

    public MainController() {}

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
    // DEBUG
    // =================================================================================================================

    public void submit() {
        System.out.println("submit");
        System.out.println(this.selectedSeats);
    }
}
