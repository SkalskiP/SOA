package books.utils;

public class CurrencyUtil {
    public static Double exchangeToPLN(String currency, Double value) {
        Double outputValue = value;
        switch (currency) {
            case "PLN":
                break;
            case "USD":
                outputValue =  Math.round(outputValue * 380.0)/100.0;
                break;
            case "EURO":
                outputValue =  Math.round(outputValue * 430.0)/100.0;
                break;
        }
        return outputValue;
    }
}
