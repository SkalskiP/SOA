package survey.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;


@ManagedBean(name="survey")
@SessionScoped
public class SurveyManager {
    private HashMap<String, String> basicInputs = new HashMap<String, String>() {{
        put("sex", "0");
    }};

    private Map<String, String> generalInputs = new HashMap<String, String>() {{
        put("name", "Name");
        put("mail", "E-Mail Address");
        put("age", "Age");
        put("sex", "Gender");
        put("education", "Education");
        put("height", "Height");

    }};

    private HashMap<String, String> womenInputs = new HashMap<>();
    private Map<String, String> womenInputsLabels = new HashMap<String, String>() {{
        put("breastCircumference", "Breast Circumference (cm)");
        put("cupSize", "Cup Size (cm)");
        put("waist", "Waist (cm)");
        put("hips", "Hips (cm)");
    }};

    private HashMap<String, String> menInputs = new HashMap<>();
    private Map<String, String> menInputsLabels = new HashMap<String, String>() {{
        put("chest", "Chest (cm)");
        put("waist", "Waist (cm)");
    }};

    private Map<String, String> sexes = new HashMap<String, String>() {{
        put("Woman", "0");
        put("Man", "1");
    }};

    private String isSurveyAccepted = "false";

    private Map<String, String> errors = new HashMap<>();

    private boolean additionalInputs;

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public HashMap<String, String> getWomenInputs() {
        return womenInputs;
    }

    public void setWomenInputs(HashMap<String, String> womenInputs) {
        this.womenInputs = womenInputs;
    }

    public Map<String, String> getWomenInputsLabels() {
        return womenInputsLabels;
    }

    public void setWomenInputsLabels(Map<String, String> womenInputsLabels) {
        this.womenInputsLabels = womenInputsLabels;
    }

    public HashMap<String, String> getMenInputs() {
        return menInputs;
    }

    public void setMenInputs(HashMap<String, String> menInputs) {
        this.menInputs = menInputs;
    }

    public Map<String, String> getMenInputsLabels() {
        return menInputsLabels;
    }

    public void setMenInputsLabels(Map<String, String> menInputsLabels) {
        this.menInputsLabels = menInputsLabels;
    }

    public Map<String, String> getSexes() {
        return sexes;
    }

    public void setSexes(Map<String, String> sexes) {
        this.sexes = sexes;
    }

    public HashMap<String, String> getBasicInputs() {
        return basicInputs;
    }

    public void setBasicInputs(HashMap<String, String> basicInput) {
        this.basicInputs = basicInput;
    }

    public Map<String, String> getGeneralInputs() {
        return generalInputs;
    }

    public void setGeneralInputs(Map<String, String> generalInputs) {
        this.generalInputs = generalInputs;
    }

    public String getIsSurveyAccepted() {
        return isSurveyAccepted;
    }

    public void setIsSurveyAccepted(String isSurveyAccepted) {
        this.isSurveyAccepted = isSurveyAccepted;
    }

    public String submit() {
        this.errors = SurveyUtil.validateData(this.basicInputs);
        System.out.println(this.errors.size());
        for (Map.Entry<String, String> entry: this.errors.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        if (this.errors.size() == 0) {
            this.isSurveyAccepted = "true";
        }
        return null;
    }

    public void updateSex() {
        System.out.println("update");
    }
}
