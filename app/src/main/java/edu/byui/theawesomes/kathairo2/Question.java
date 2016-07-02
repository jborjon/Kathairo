package edu.byui.theawesomes.kathairo2;

/**
 * Created by fmcho on 7/1/2016.
 */
public class Question {
    private String question;
    private boolean isDisplayed = false;

    public String getQuestion(){
        return question;
    }
    public void setClue(String toSet){
        question = toSet;
    }

    public void setDisplayed(boolean toSet){
        isDisplayed = toSet;
    }

    public Boolean getIsDisplayed(){
        return isDisplayed;
    }


}
