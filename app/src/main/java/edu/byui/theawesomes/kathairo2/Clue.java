package edu.byui.theawesomes.kathairo2;

/**
 * Created by fmcho on 7/1/2016.
 */
public class Clue {
    //the clue the user gets so they can give us the answer
    private String clue;
    private boolean isDisplayed = false;

    protected Clue(String string){
        this.clue = string;
    }

    protected Clue(){
        this.clue = null;
    }


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
