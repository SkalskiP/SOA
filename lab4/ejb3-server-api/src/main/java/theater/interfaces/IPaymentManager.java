package theater.interfaces;

import theater.dto.CustomerDTO;

import javax.ejb.Lock;

public interface IPaymentManager {
    @Lock
    void executeTransaction(CustomerDTO customer, Integer amount);
}
