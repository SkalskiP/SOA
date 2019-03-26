package survey.domain;

public class NumberQuestion extends Question {
    private int minValue;
    private int maxValue;
    private int selectedValue;

    public NumberQuestion(String content, int minValue, int maxValue) {
        this.content = content;
        this.type = "NUMBER";
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(int selectedValue) {
        this.selectedValue = selectedValue;
    }
}
