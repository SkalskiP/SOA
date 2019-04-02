package theater.beans;

import theater.dao.CustomerDAO;
import theater.dto.CustomerDTO;
import theater.interfaces.ICustomerManager;
import theater.interfaces.remote.IRemoteCustomerManager;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
@Remote(IRemoteCustomerManager.class)
public class CustomerManagerBean implements ICustomerManager {
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return CustomerDAO.getInstance().getItems();
    }

    @Override
    public CustomerDTO getCustomerById(String customerId) {
        return CustomerDAO.getInstance().getItem(customerId);
    }

    @Override
    public Double getCustomerBalance(CustomerDTO customer) {
        return CustomerDAO.getInstance().getItem(customer.getId()).getBalance();
    }
}
