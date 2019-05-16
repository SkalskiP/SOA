package service;

import domain.Currency;
import util.CurrencyCalculator;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    @WebMethod
    public Double getExchangeRateToPLN(String currencyString) {
        Currency currency = CurrencyCalculator.convertStringCurrency(currencyString);
        return CurrencyCalculator.getExchangeRateToPLN(currency);
    }

    @Override
    @WebMethod
    public Double exchangeToPLN(String currencyString, Double amount) {
        Currency currency = CurrencyCalculator.convertStringCurrency(currencyString);
        return CurrencyCalculator.exchangeToPLN(currency, amount);
    }
}
