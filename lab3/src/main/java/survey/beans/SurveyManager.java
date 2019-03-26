package survey.beans;

import survey.domain.Question;
import survey.domain.QuestionsSurvey;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

@ManagedBean(name="survey")
@ViewScoped
public class SurveyManager {
    ArrayList<Question> baseQuestionsSection = QuestionsSurvey.getBaseQuestionsSection();
    Boolean stageOnePassed = false;

    public ArrayList<Question> getBaseQuestionsSection() {
        return baseQuestionsSection;
    }

    public void setBaseQuestionsSection(ArrayList<Question> baseQuestionsSection) {
        this.baseQuestionsSection = baseQuestionsSection;
    }

    public Boolean getStageOnePassed() {
        return stageOnePassed;
    }

    public void setStageOnePassed(Boolean stageOnePassed) {
        this.stageOnePassed = stageOnePassed;
    }
}
