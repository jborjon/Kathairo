package edu.byui.theawesomes.kathairo2;

import android.util.Log;

/**
 * @author      Joseph Borjon
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Word {
    /*
     * This is the clue the user will recevie it is an object
     */
    private Clue clue;
    /*
     * This is set by using setWord() and you pass it a string
     * it is the answer that we are looking for
     */
    private String answer;
    // private List<CharacterCell> answer = new ArrayList<CharacterCell>();
    /*
     * this is the number of letters in the answer
     * let's rename this to answer (from word) find and replace
     */
    private int numberofLettersInAnswer;
    /*
     * this is the clue number within the list of clues
     */
    private int clueNumber;

    private int row;

    private int col;

    private boolean isDown;

    /****************************************************
     * Default Constructor to set up things initally
     *****************************************************/
    protected Word() {
        this.clue = new Clue();
        this.setClueNumber(0);
        this.answer = null;
        this.numberofLettersInAnswer = 0;
        this.col = 0;
        this.row = 0;
        this.isDown = false;
    }

    /****************************************************
     *This sets the word
     * <p>
     *     This uses a loop to be able to set the words
     *     properly.
     * </p>
     *
     * @param answerToSet String
     *****************************************************/
    public void setAnswer(String answerToSet){

        String tempAnswer = "";

        int lengthOfAnswer = answerToSet.length();

        for(int i = 0; i < lengthOfAnswer; i++){
            tempAnswer += Character.toUpperCase(answerToSet.charAt(i));
        }

        this.answer = tempAnswer;

        this.numberofLettersInAnswer = lengthOfAnswer;
    }

    public void setRow(int intToSet) {this.row = intToSet;}
    public void setCol(int intToSet) {this.col = intToSet;}
    public void setIsDown(Boolean boolToSet) {this.isDown = boolToSet;}

    public int getRow() {return this.row;}
    public int getCol() {return this.col;}
    public boolean getIsDown() {return this.isDown;}

    /****************************************************
     *This get's the word
     * <p>
     *  This gets the word for the user to use
     *
     * </p>
     *
     *
     * @return String completeWord
     *****************************************************/
    public String getAnswer(){Log.e("SCREWED","returning answer"); return this.answer; }

    /****************************************************
     * Gets the number of characters in a word.
     * @return int numberCharactersInTheWord
     *****************************************************/
    public int getNumberOfLettersInAnswer(){
        return numberofLettersInAnswer;
    }

    /****************************************************
     * This sets the number of words.
     * @param index int
     *****************************************************/
    public void setClueNumber(int index){
        clueNumber = index;
    }

    /****************************************************
     * Gets the number of the word
     * @return String clueNumber
     *****************************************************/
    public int getClueNumber(){
        return clueNumber;
    }

    /****************************************************
     * Gets the number of the word
     * @param ClueToSet String
     *****************************************************/
    public void setClue(String ClueToSet){
        if(clue != null) {
            clue.setClue(ClueToSet);
        }
        else{
            clue = new Clue(ClueToSet);
        }

    }

    /****************************************************
     * Gets the number of the word
     * @return clue.getClue()
     *****************************************************/
    public String getClue(){
        return clue.getClue();
    }
}
