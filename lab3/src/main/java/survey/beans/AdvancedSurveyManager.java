package survey.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "advancedSurvey")
@SessionScoped
public class AdvancedSurveyManager {
    private Map<String, String> additonals = new HashMap<>();
    private Map<String, String> additionalLabels = new HashMap<String, String>() {{
        put("spendMoney", "How much can you spend per month on clothes?");
        put("buyingPeriod", "How often do you buy clothes?");
        put("preferColor", "In which colours do you prefer clothes?");
        put("preferType", "What kind of clothes do you prefer to buy?");
    }};

    private Map<String, String> spendMoneyOptions = new HashMap<String, String>() {{
        put("up to PLN 100", "0");
        put("PLN 100-500", "1");
        put("PLN 500-1000", "2");
        put("over 1000 PLN", "3");

    }};
    private Map<String, String> buyingPeriodOptions = new HashMap<String, String>() {{
        put("Daily", "0");
        put("Once a week", "1");
        put("Once a month", "2");
        put("Several times a year", "3");

    }};
    private Map<String, String> preferColorOptions = new HashMap<String, String>() {{
        put("Colourful and bright", "0");
        put("Subdued in grey", "1");
        put("In black and white", "2");
        put("In black alone", "3");

    }};
    private Map<String, String> preferTypeOptions = new HashMap<String, String>() {{
        put("Suits", "0");
        put("Blouses", "1");
        put("Skirts", "2");
        put("Trousers", "3");
    }};

    public Map<String, String> getAdditonals() {
        return additonals;
    }

    public void setAdditonals(Map<String, String> additonals) {
        this.additonals = additonals;
    }

    public Map<String, String> getAdditionalLabels() {
        return additionalLabels;
    }

    public void setAdditionalLabels(Map<String, String> additionalLabels) {
        this.additionalLabels = additionalLabels;
    }

    public Map<String, String> getSpendMoneyOptions() {
        return spendMoneyOptions;
    }

    public void setSpendMoneyOptions(Map<String, String> spendMoneyOptions) {
        this.spendMoneyOptions = spendMoneyOptions;
    }

    public Map<String, String> getBuyingPeriodOptions() {
        return buyingPeriodOptions;
    }

    public void setBuyingPeriodOptions(Map<String, String> buyingPeriodOptions) {
        this.buyingPeriodOptions = buyingPeriodOptions;
    }

    public Map<String, String> getPreferColorOptions() {
        return preferColorOptions;
    }

    public void setPreferColorOptions(Map<String, String> preferColorOptions) {
        this.preferColorOptions = preferColorOptions;
    }

    public Map<String, String> getPreferTypeOptions() {
        return preferTypeOptions;
    }

    public void setPreferTypeOptions(Map<String, String> preferTypeOptions) {
        this.preferTypeOptions = preferTypeOptions;
    }
    public String submit() {
        for (Map.Entry<String, String> entry: this.additonals.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return "surveySummary";
    }

}
