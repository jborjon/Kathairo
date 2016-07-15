package edu.byui.theawesomes.kathairo2;

/**
 * DO we need this???
 * Created by fmcho on 7/1/2016.
 */
//random comment to get this commited and pushed!

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
