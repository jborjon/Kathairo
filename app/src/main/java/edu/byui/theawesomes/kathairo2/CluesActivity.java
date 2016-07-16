package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CluesActivity extends AppCompatActivity {

    private Crossword crossword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clues);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*******************
         * Load the crossword
         ********************/
        AssetManager assetManager = getAssets();
        try {
            crossword = new Crossword(assetManager);
        } catch (IOException e) {
            Log.e("MAJOR ERROR",e.toString());
            e.printStackTrace();
        }

        // Display the clues
        displayClues(crossword);
    }

    /****************************************************
     * This sets changes the activity to the Crossword
     * @param v
     *****************************************************/
    public void newGameOnClick(View v){
        Intent intent = new Intent(this, CrosswordActivity.class);
        startActivity(intent);
    }

    /****************************************************
     * This sets changes the activity to the Main menu
     * @param v
     *****************************************************/
    public void mainMenuOnClick(View v){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    /****************************************************
     * This displays the crossword clues on the screen
     * @param crosswordWord
     *****************************************************/
    protected void displayClues(Crossword crosswordWord) {

        //Declare the variables they will be stored in
        List<Word> crossswordList;

        crossswordList = crosswordWord.getCrosswordList();

        // Get the appropriate text field
        TextView cluesTextField = (TextView) findViewById(R.id.cluesList);

        // Put the down clues on the screen
        cluesTextField.append("Down:" + "\n");
        for (int i = 0; i < crossswordList.size(); ++i) {
            //so it's easier to read
            Word word = crossswordList.get(i);
            //Put the clue number in text
            if(word.getIsDown()) {
                //put the clue number & clue in the text field
                cluesTextField.append(word.getClueNumber() + ". "+word.getClue()+ " ");
                //put the amount of letters in the clue in the text field
                cluesTextField.append(word.getNumberOfLettersInAnswer() + " letters" + "\n");
            }
        }

        //add a space in between the two
        cluesTextField.append("\n");

        // Put the across clues on the screen
        cluesTextField.append("Across:" + "\n");
        for (int i = 0; i < crossswordList.size(); ++i) {
            //so it's easier to read
            Word word = crossswordList.get(i);
            //Put the clue number in text
            if(!(word.getIsDown())) {
                //put the clue number & clue in the text field
                cluesTextField.append(word.getClueNumber() + ". "+word.getClue()+ " ");
                //put the amount of letters in the clue in the text field
                cluesTextField.append(word.getNumberOfLettersInAnswer() + " letters" + "\n");
            }
        }
    }
}
