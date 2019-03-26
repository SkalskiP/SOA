package survey.beans;

import java.util.HashMap;
import java.util.Map;

public class SurveyUtil {
    public static Map<String, String> validateData(Map<String, String> data) {
        Map<String, String> errors = new HashMap<>();

        for (Map.Entry<String, String> input: data.entrySet()) {
            switch (input.getKey()) {
                case "name":
                    if (input.getValue().isEmpty())
                        errors.put("name", "This field is required");
                    break;
                case "mail":
                    String msg = "";
                    String patternMail= "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
                    if(input.getValue().isEmpty())
                        msg += "This field is required.\n";
                    if(!input.getValue().matches(patternMail))
                        msg += "Invalid field format.\n";
                    if(msg.length() > 0)
                        errors.put("mail", msg);
                    break;
                case "age":
                    try {
                        int age = Integer.parseInt(input.getValue());
                        if (age <= 10 || age >= 100)
                            errors.put("age", "Invalid age range");
                    } catch (Exception e) {
                        errors.put("age", "Bad age format");
                    }
                    break;
                case "height":
                    try {
                        int height = Integer.parseInt(input.getValue());
                        if (data.get("sex").equals("0")) {
                            if(height <= 150 || height >= 185)
                                errors.put("height", "Invalid height range");
                        } else {
                            if(height <= 165 || height >= 200)
                                errors.put("height", "Invalid height range");
                        }
                    } catch (Exception e) {
                        errors.put("height", "Bad height format");
                    }
                    break;
            }
        }
        return errors;
    }
}
