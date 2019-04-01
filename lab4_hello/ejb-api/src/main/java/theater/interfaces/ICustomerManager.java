package theater.interfaces;

import theater.dto.CustomerDTO;

import java.util.ArrayList;

public interface ICustomerManager {
    ArrayList<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(String customerId);
}
