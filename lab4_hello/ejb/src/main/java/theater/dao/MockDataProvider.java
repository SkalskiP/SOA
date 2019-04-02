package theater.dao;

import theater.dto.CustomerDTO;
import theater.dto.EventDTO;
import theater.dto.SeatDTO;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

public class MockDataProvider {
    private static MockDataProvider instance;
    private ArrayList<CustomerDTO> customers;
    private ArrayList<EventDTO> events;

    private MockDataProvider() {
        customers = new ArrayList<>();
        events = new ArrayList<>();
        loadCustomers();
        loadEvents();
    }

    public static MockDataProvider getInstance() {
        if (instance == null) {
            instance = new MockDataProvider();
        }
        return instance;
    }

    public ArrayList<CustomerDTO> getCustomers() {
        return customers;
    }
    public ArrayList<EventDTO> getEvents() {
        return events;
    }

    private void loadCustomers() {
        customers.add(new CustomerDTO("Piotr", "Skalski", 200.0));
        customers.add(new CustomerDTO("Grzegorz", "Krzemiński", 1000.0));
        customers.add(new CustomerDTO("Maja", "Borzemska", 0.0));
    }

    private void loadEvents() {
        String[] eventNames = {
            "Śluby panieńskie",
            "Hamlet",
            "Zemsta",
            "Biesy",
            "Błękitne krewetki"
        };

        LocalDateTime[] eventDates = {
            LocalDateTime.of(2019, Month.APRIL, 3, 19, 0),
            LocalDateTime.of(2019, Month.APRIL, 5, 18, 0),
            LocalDateTime.of(2019, Month.APRIL, 9, 19, 0),
            LocalDateTime.of(2019, Month.APRIL, 12, 18, 0),
            LocalDateTime.of(2019, Month.APRIL, 24, 19, 0)
        };

        Character[] rows = {'A', 'B', 'C', 'D', 'E'};

        HashMap<Character, Double> rowPricing = new HashMap<Character, Double>();
        rowPricing.put('A', 80.0);
        rowPricing.put('B', 70.0);
        rowPricing.put('C', 60.0);
        rowPricing.put('D', 55.0);
        rowPricing.put('E', 50.0);

        for (int i = 0; i < 5; i++) {
            ArrayList<SeatDTO> seats = new ArrayList<>();
            for (Character row: rows){
                for (int index = 1; index <= 10; index++) {
                    seats.add(new SeatDTO(index, row));
                }
            }
            events.add(new EventDTO(eventNames[i], eventDates[i], rowPricing, seats));
        }
    }
}
