package theater.dao;

import theater.dto.EventDTO;

import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    private static EventDAO instance;

    private EventDAO() {

    }

    public static EventDAO getInstance() {
        if (instance == null) {
            instance = new EventDAO();
        }
        return instance;
    }

    public ArrayList<EventDTO> getItems() {
        return MockDataProvider.getInstance().getEvents();
    }

    public EventDTO getItem(String id) {
        return MockDataProvider.getInstance().getEvents().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
    }

    public void updateItem(EventDTO event) {
        MockDataProvider.getInstance().getEvents()
                .stream()
                .filter(e -> e.getId().equals(event.getId()))
                .findAny()
                .ifPresent(e -> {
                    e.setDate(event.getDate());
                    e.setName(event.getName());
                    e.setSeats(event.getSeats());
                });
    }
}