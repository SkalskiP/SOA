package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CurrencyService {
    @WebMethod
    Double getExchangeRateToPLN(String currencyString);

    @WebMethod
    Double exchangeToPLN(String currencyString, Double amount);
}
