package edu.byui.theawesomes.kathairo2;

/**
 * Created by fmcho on 7/1/2016.
 */
public class Clue {
    private String clue;
    private boolean isDisplayed = false;

    public String getClue(){
        return clue;
    }
    public void setClue(String toSet){
        clue = toSet;
    }

    public void setDisplayed(boolean toSet){
        isDisplayed = toSet;
    }

    public Boolean getIsDisplayed(){
        return isDisplayed;
    }

}
