package survey.domain;

public class TextQuestion extends Question {
    private String response = "";

    public TextQuestion(String content, Boolean required) {
        this.content = content;
        this.type = "TEXT";
        this.required = required;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response =     response;
    }
}
