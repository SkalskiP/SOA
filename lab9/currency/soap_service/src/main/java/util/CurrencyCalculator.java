package util;

import domain.Currency;

public class CurrencyCalculator {
    public static Double getExchangeRateToPLN(Currency currency) {
        switch (currency) {
            case EUR: return 4.300173;
            case USD: return 3.846894;
            case JPY: return 0.350260;
            case PLN: return 1.000000;
            default: return 1.000000;
        }
    }

    public static Double exchangeToPLN(Currency currency, Double amount) {
        Double rate = CurrencyCalculator.getExchangeRateToPLN(currency);
        return CurrencyCalculator.round(rate * amount, 2);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static Currency convertStringCurrency(String currencyString) {
        return Currency.valueOf(currencyString);
    }
}
