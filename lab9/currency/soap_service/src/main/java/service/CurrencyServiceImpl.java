package service;

import domain.Currency;
import util.CurrencyCalculator;

public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public Double getExchangeRateToPLN(String currencyString) {
        Currency currency = CurrencyCalculator.convertStringCurrency(currencyString);
        return CurrencyCalculator.getExchangeRateToPLN(currency);
    }

    @Override
    public Double exchangeToPLN(String currencyString, Double amount) {
        Currency currency = CurrencyCalculator.convertStringCurrency(currencyString);
        return CurrencyCalculator.exchangeToPLN(currency, amount);
    }
}
