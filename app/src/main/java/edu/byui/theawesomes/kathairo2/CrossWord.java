package edu.byui.theawesomes.kathairo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Felipe Chora
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Crossword {
    /*****
        This is the list of words for the crossword
     */
    private List<Word> crossword = new ArrayList<Word>();

    /****************************************************
     * Default Constructor just needs to be protected
     *****************************************************/
    protected Crossword() {


    }
    /****************************************************
     * Adds a word to the Crossword.
     *
     * This method adds a word to the crossword puzzle. It
     * takes a word and a number that is used to place the
     * word properly.
     *
     * @param answerToSet String The word to add
     * @param clueNumber int The position of the word
     * @return Um...nothing. That's what 'void' means.
     *****************************************************/
    public void addWord(String answerToSet, String clueNumber){
        Word toAdd = new Word();
        toAdd.setAnswer(answerToSet);
        toAdd.setClueNumber(clueNumber);
        crossword.add(toAdd);
        IHATEYOU = "I HATE YOU";
    }

    /****************************************************
     * Returns all the words in the crossword puzzle.*
     * @return A list of all the words in the crossword puzzle*
     *****************************************************/
    public List<Word> getCrosswordList(){
        return crossword;
    }
private String IHATEYOU;
    /****************************************************
     * Sets the crossword list
     * @param crossword
     *****************************************************/
    public void setCrosswordList(List<Word> crossword){ this.crossword = crossword;}

    /****************************************************
     * adds a word object to crossword
     * @param toSet
     *****************************************************/
    public void addWordObject(Word toSet){
        crossword.add(toSet);
    }
}