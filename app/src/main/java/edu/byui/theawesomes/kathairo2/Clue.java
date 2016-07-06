package edu.byui.theawesomes.kathairo2;

/**
 * Created by fmcho on 7/1/2016.
 */
public class Clue {
    //the clue the user gets so they can give us the answer
    private String clue;
    //if we the puzzle screen is to display this clue
    private boolean isDisplayed = false;

    /****************************************************
     * Non default constructor to instantiate the string clue
     *****************************************************/
    protected Clue(String clue){
        this.clue = clue;
    }

    /****************************************************
     * Default constructor to instantiate the string clue
     *****************************************************/
    protected Clue(){
        this.clue = null;
    }


    /****************************************************
     * gets the crossword list
     * @return clue
     *****************************************************/
    public String getClue(){
        return clue;
    }

    /****************************************************
     * Sets the crossword list
     * @param clue
     *****************************************************/
    public void setClue(String clue){
        this.clue = clue;
    }

    /****************************************************
     * gets the crossword list
     * @return clue
     *****************************************************/
    public Boolean getIsDisplayed(){
        return isDisplayed;
    }

    /****************************************************
     * Sets the crossword list
     * @param toSet
     *****************************************************/
    public void setDisplayed(boolean toSet){
        isDisplayed = toSet;
    }
}
