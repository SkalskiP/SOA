package theater.beans;

import theater.dao.CustomerDAO;
import theater.dto.CustomerDTO;
import theater.interfaces.IPaymentManager;
import theater.interfaces.remote.IRemotePaymentManager;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(IRemotePaymentManager.class)
@Local
public class PaymentManagerBean implements IPaymentManager {

    @Override
    public void executeTransaction(CustomerDTO customer, Double price) {
        customer.setBalance(customer.getBalance() - price);
        CustomerDAO.getInstance().updateItem(customer);
    }
}
