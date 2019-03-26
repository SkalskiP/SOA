package survey.domain;

import java.util.ArrayList;

public class OptionQuestion extends Question{
    private ArrayList<String> options;
    private int selectedOption = 0;

    public OptionQuestion(String content, ArrayList<String> options) {
        this.content = content;
        this.type = "OPTION";
        this.options = options;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }
}
