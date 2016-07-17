package edu.byui.theawesomes.kathairo2;

import android.content.res.AssetManager;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author      Felipe Chora
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Crossword {

    /*****
     * This is the array for the valid inputs
     * helps set the textbox
     */
    private Boolean[][] validInput = new Boolean[16][22];

    /*****
     This is the list of valid answers
     helps check the answers
     */
    private Character[][] validAnswer = new Character[16][22];

    /*****
     This is the list of words for the crossword
     */
    private List<Word> crossword = new ArrayList<>();

    /****************************************************
     * Default Constructor
     *****************************************************/
    public Crossword(AssetManager assetManager){

        XmlParser crosswordXmlParser = new XmlParser();
        try {
            crossword = crosswordXmlParser.parse(assetManager.open("crossword.xml"));
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        setValidInput();
        setValidAnswers();
    }

    /**********************************************************
     * Returns all the words in the crossword puzzle.
     * @return A list of all the words in the crossword puzzle
     **********************************************************/
    public List<Word> getCrosswordList(){
        return crossword;
    }

    /****************************************************
     * gets the valid answer array and returns it
     * @return validAnswer
     *****************************************************/
    public Character[][] getValidAnswer(){
        return validAnswer;
    }

    /****************************************************
     * gets the valid input array and returns it
     * @return validInput
     *****************************************************/
    public Boolean[][] getValidInput(){
        return validInput;
    }

    /****************************************************
     * Sets valid input utlizing the List of words
     *****************************************************/
    public void setValidInput(){

        int validInputLength = validInput.length-1;

        //intialize the values to false because that's the default
        for (int i = 0; i <= validInputLength; i++) {

            Arrays.fill(validInput[i], Boolean.FALSE);
        }

        int lengthOfCrossword = getCrosswordList().size();

        //we are going to go through all the words in the crossword
        for (int i = 0; i < lengthOfCrossword; i++) {

            //so we don't have to keep calling this function
            Word word = getCrosswordList().get(i);

            //assign the row for this word
            int row = word.getRow();
            //assign the col for this word
            int col = word.getCol();

            int lengthOfAnswer = word.getNumberOfLettersInAnswer();

            //check to see if this is a word that goes across or down.
            if (word.getIsDown()) {

                //start at the parent row and goes down to the end
                for (int r = row; r < lengthOfAnswer + row; r++) {

                    //collumn stays the same while the row goes down
                    validInput[r][col] = true;

                }
            } else {

                //start at the parent col and goes across to the end
                for (int c = col; c < lengthOfAnswer + col; c++) {

                    //collumn stays the same while the collumn goes down
                    validInput[row][c] = true;

                }
            }
        }
    }

    /****************************************************
     * Sets valid answer utlizing the List of words
     *****************************************************/
    public void setValidAnswers() {

        //so we don't keep calling this function
        int size = getCrosswordList().size();

        //we are going to go through all the words in the crossword
        for (int i = 0; i < size; i++) {

            //so we don't have to keep calling this function
            Word word = getCrosswordList().get(i);

            int row = word.getRow();
            int col = word.getCol();
            // create a variable so that we can loop through the word
            int count = 0;

            String answer = word.getAnswer();
            int wordLength = word.getNumberOfLettersInAnswer();

            //check to see if this is a word that goes across or down.
            if (word.getIsDown()) {
                //start at the parent row and goes down to the end

                for (int r = row; r < wordLength + row; r++) {

                    //collumn stays the same while the row goes down
                    validAnswer[r][col] = answer.charAt(count);
                    count++;

                }

            } else {

                //start at the parent col and goes across to the end
                for (int c = col; c < wordLength + col; c++) {

                    //collumn stays the same while the collumn goes down
                    validAnswer[row][c] = answer.charAt(count);//word.getLetter(count).charAt(0));
                    count++;

                }
            }
        }
    }
}