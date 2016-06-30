package edu.byui.theawesomes.kathairo2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fmcho on 6/29/2016.
 */
public class Word {

    /*

     */
    private List<CharacterCell> word = new ArrayList<CharacterCell>();
    /*

     */
    private int numberCharactersInTheWord;
    /*

     */
    private int numberOfTheWord = 0;

    /****************************************************
     *
     *
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
     *
     *
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
     *
     *
     *****************************************************/
    public int getNumberOfCharactersInTheWord(){
        return numberCharactersInTheWord;
    }

    /****************************************************
     *
     *
     *****************************************************/
    public void setNumberOfTheWord(int index){
        numberOfTheWord = index;
    }

    /****************************************************
     *
     *
     *****************************************************/
    public int getNumberOfTheWord(){
        return numberOfTheWord;
    }
}
