package edu.byui.theawesomes.kathairo2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Joseph Borjon
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class

Word {
    /*
     * This is the clue the user will recevie it is an object
     */
    private Clue clue;
    /*
     * This is set by using setWord() and you pass it a string
     * it is the answer that we are looking for
     */
    private List<CharacterCell> answer = new ArrayList<CharacterCell>();
    /*
     * this is the number of letters in the answer
     * let's rename this to answer (from word) find and replace
     */
    private int numberofLettersInAnswer;
    /*
     * this is the clue number within the list of clues
     */
    private String clueNumber;

    /****************************************************
     * Non-Default Constructor to set up everything
     *****************************************************/
    protected Word(Clue clue, String answer, String clueNumber, int row, int column) {
        this.clue = clue;
        this.setAnswer(answer, row, column);
        this.clueNumber = clueNumber;
        //this.setClueNumber(clueNumber);
    }

    /****************************************************
     * Default Constructor to set up things initally
     *****************************************************/
    protected Word() {
        this.clue = new Clue();
        this.setClueNumber(null);
    }

    public String getLetter(int index){

        String character = "";
        CharacterCell toReturn = new CharacterCell();
        for (int i = 0; i < answer.size(); i++) {
            if(i == index) {
                toReturn = answer.get(i);
                character = toReturn.getCharacter();
            }
        }
        return character;
    }
    /****************************************************
     *This sets the word
     * <p>
     *     This uses a loop to be able to set the words
     *     properly.
     * </p>
     *
     * @param answerToSet
     * @return nothing
     *****************************************************/

    public void setAnswer(String answerToSet, int row, int column){
            for (int i = 0; i < answerToSet.length(); i++) {
                CharacterCell cell = new CharacterCell();
                cell.setCharacter("" + answerToSet.charAt(i));
                cell.setIndex(i);
                cell.setRow(row);
                cell.setColumn(column);
                numberofLettersInAnswer = i + 1;
                answer.add(cell);
            }
            Log.i("setWord", "Word set");
    }

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
    public String getAnswer(){

        String completeAnswer = "";
        for (int i = 0; i < answer.size(); i++) {
            completeAnswer += answer.get(i).getCharacter();
            Log.i("getWord()Parts", completeAnswer);
        }
        Log.i("getWord()", completeAnswer);

        return completeAnswer;
    }

    /****************************************************
     * Gets the number of characters in a word.
     * @param
     * @return int numberCharactersInTheWord
     *****************************************************/
    public int getNumberOfLettersInAnswer(){
        return numberofLettersInAnswer;
    }

    /****************************************************
     * This sets the number of words.
     * @param index
     * @return void
     *****************************************************/
    public void setClueNumber(String index){
        clueNumber = index;
    }

    /****************************************************
     * Gets the number of the word
     * @param
     * @return String clueNumber
     *****************************************************/
    public String getClueNumber(){
        return clueNumber;
    }

    /****************************************************
     * Gets the number of the word
     * @param ClueToSet
     * @return
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
     * @param
     * @return clue.getClue()
     *****************************************************/
    public String getClue(){
        return clue.getClue();
    }
}
