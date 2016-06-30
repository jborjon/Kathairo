package edu.byui.theawesomes.kathairo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fmcho on 6/29/2016.
 */
public class CrossWord {
    /**

     */
    private List<Word> crossword = new ArrayList<Word>();

    /****************************************************
     * Adds a word to the Crossword.
     *
     * This method adds a word to the crossword puzzle. It
     * takes a word and a number that is used to place the
     * word properly.
     *
     * @param wordToSet String The word to add
     * @param numberOfWord int The position of the word
     * @return Um...nothing. That's what 'void' means.
     *****************************************************/
    public void addWord(String wordToSet, int numberOfWord){
        Word toAdd = new Word();
        toAdd.setWord(wordToSet);
        toAdd.setNumberOfTheWord(numberOfWord);
        crossword.add(toAdd);

    }
    /****************************************************
     *
     *
     *****************************************************/
    public List<Word> getCrosswordList(){
        return crossword;
    }
}