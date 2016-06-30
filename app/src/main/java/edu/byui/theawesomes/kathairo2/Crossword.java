package edu.byui.theawesomes.kathairo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fmcho on 6/29/2016.
 */
public class CrossWord {
    private List<Word> crossword = new ArrayList<Word>();
    /** we will have to create a function that reads an XML file and then to create words and clues objects.
     */
    public void addWord(String wordToSet, int numberOfWord){
        Word toAdd = new Word();
        toAdd.setWord(wordToSet);
        toAdd.setNumberOfTheWord(numberOfWord);
        crossword.add(toAdd);

    }
    public List<Word> getCrosswordList(){
        return crossword;
    }
}
