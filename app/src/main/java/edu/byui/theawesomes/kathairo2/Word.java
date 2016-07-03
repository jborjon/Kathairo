package edu.byui.theawesomes.kathairo2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Joseph Borjon
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Word {

    private Clue clue;


    public void setClue(String toSet){
        clue.setClue(toSet);
    }

    public String getClue(){
        return clue.getClue();
    }
    /*
     *
     */
    private List<CharacterCell> word = new ArrayList<CharacterCell>();
    /*
     *
     */
    private int numberCharactersInTheWord;
    /*
     *
     */
    private int numberOfTheWord = 0;

    /****************************************************
     *This sets the word
     * <p>
     *     This uses a loop to be able to set the words
     *     properly.
     * </p>
     *
     * @param String wordToSet
     * @return nothing
     *****************************************************/
    public void setWord(String wordToSet){

        for(int i = 0; i < wordToSet.length(); i++){
            CharacterCell cell = new CharacterCell();
            cell.setCharacter("" + wordToSet.charAt(i));
            cell.setIndex(i);
            numberCharactersInTheWord = i;
            word.add(cell);
        }
        Log.i("setWord","Word set");
    }

    /****************************************************
     *This get's the word
     * <p>
     *  This gets the word for the user to use
     *
     * </p>
     *
     * @param none
     * @return String completeWord
     *****************************************************/
    public String getWord(){
        String completeWord = "";
        for (int i = 0; i < word.size(); i++) {
            completeWord += word.get(i).getCharacter();
            Log.i("getWord()Parts", completeWord);
        }
        Log.i("getWord()", completeWord);

        return completeWord;
    }

    /****************************************************
     * Gets the number of characters in a word.
     * @param nothing
     * @return int numberCharactersInTheWord
     *****************************************************/
    public int getNumberOfCharactersInTheWord(){
        return numberCharactersInTheWord;
    }

    /****************************************************
     * This sets the number of words.
     * @param index
     * @return void
     *****************************************************/
    public void setNumberOfTheWord(int index){
        numberOfTheWord = index;
    }

    /****************************************************
     * Gets the number of the word
     * @param Nothing
     * @return int numberOfTheWord
     *****************************************************/
    public int getNumberOfTheWord(){
        return numberOfTheWord;
    }
}
