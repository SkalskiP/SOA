package survey.domain;

import java.util.ArrayList;

public class QuestionsSurvey {
    public static ArrayList<Question> getBaseQuestionsSection() {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new TextQuestion("Name", true));
        questions.add(new TextQuestion("Email Address", true));
        questions.add(new NumberQuestion("Age", 10, 100));

        ArrayList<String> fourthQuestionOptions = new ArrayList<>();
        fourthQuestionOptions.add("Men");
        fourthQuestionOptions.add("Woman");

        questions.add(new OptionQuestion("Sex", fourthQuestionOptions));

        ArrayList<String> fifthQuestionOptions = new ArrayList<>();
        fifthQuestionOptions.add("Primary education");
        fifthQuestionOptions.add("Secondary education");
        fifthQuestionOptions.add("Higher education");

        questions.add(new OptionQuestion("Education", fifthQuestionOptions));

        return questions;
    }

    public static ArrayList<Question> getAdditionalQuestionsSection() {
        ArrayList<Question> questions = new ArrayList<>();

        ArrayList<String> firstQuestionOptions = new ArrayList<>();
        firstQuestionOptions.add("up to PLN 100");
        firstQuestionOptions.add("PLN 100-500");
        firstQuestionOptions.add("PLN 500-1000");
        firstQuestionOptions.add("over 1000 PLN");

        questions.add(new OptionQuestion("How much can you spend per month on clothes?", firstQuestionOptions));

        ArrayList<String> secondQuestionOptions = new ArrayList<>();
        secondQuestionOptions.add("Daily");
        secondQuestionOptions.add("Once a week");
        secondQuestionOptions.add("Once a month");
        secondQuestionOptions.add("Several times a year");

        questions.add(new OptionQuestion("How often do you buy clothes?", secondQuestionOptions));

        ArrayList<String> thirdQuestionOptions = new ArrayList<>();
        thirdQuestionOptions.add("Colourful and bright");
        thirdQuestionOptions.add("Subdued in grey");
        thirdQuestionOptions.add("In black and white");
        thirdQuestionOptions.add("In black alone");

        questions.add(new OptionQuestion("In which colours do you prefer clothes?", thirdQuestionOptions));

        return questions;
    }
}
