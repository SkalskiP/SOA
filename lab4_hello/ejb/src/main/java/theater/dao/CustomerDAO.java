package theater.dao;

import theater.dto.CustomerDTO;

import java.util.ArrayList;

public class CustomerDAO {
    private static CustomerDAO instance;

    private CustomerDAO() {}

    public static CustomerDAO getInstance() {
        if (instance == null) {
            instance = new CustomerDAO();
        }
        return instance;
    }

    public ArrayList<CustomerDTO> getItems() {
        return MockDataProvider.getInstance().getCustomers();
    }

    public CustomerDTO getItem(String id) {
        return MockDataProvider.getInstance().getCustomers().stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
    }

    public void updateItem(CustomerDTO customer) {
        MockDataProvider.getInstance().getCustomers()
                .stream()
                .filter(c -> c.getId().equals(customer.getId()))
                .findAny()
                .ifPresent(c -> {
                    c.setBalance(customer.getBalance());
                    c.setName(customer.getName());
                    c.setSurname(customer.getSurname());
                });
    }
}
