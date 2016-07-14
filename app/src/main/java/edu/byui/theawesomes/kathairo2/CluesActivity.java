package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CluesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clues);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*******************
         * Load the crossword
         */
        Crossword crossword = new Crossword();
        //Below is testing to get the xml file to work
        try {
            CrosswordXmlParser crosswordXmlParser = new CrosswordXmlParser();
            AssetManager assetManager = getAssets();
            crossword.setCrosswordList(crosswordXmlParser.parse(assetManager.open("crossword.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        // Display the clues
        displayClues(crossword);
    }

    public void mainMenuOnClick(View v){
        Intent i = new Intent(this, MainScreen.class);
        //i.putExtras(bundle);
        startActivity(i);
    }

    public void newGameOnClick(View v){
        Intent i = new Intent(this, CrosswordActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
    }

    public void cluesOnClick(View v){
        Intent i = new Intent(this, CluesActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
    }

    protected void displayClues(Crossword crosswordWord) {

        //Declare the variables they will be stored in
        List<Word> crossswordList = new ArrayList<Word>();

        crossswordList = crosswordWord.getCrosswordList();

        // Get the appropriate text field
        TextView cluesTextField = (TextView) findViewById(R.id.cluesList);

        // Put the down clues on the screen
        cluesTextField.append("Down:" + "\n");
        for (int i = 0; i < crossswordList.size(); ++i) {
            //Put the clue number in text
            if(crossswordList.get(i).getIsDown()) {

                cluesTextField.append(crossswordList.get(i).getClueNumber() + ". ");
                //put the Clue in the text
                cluesTextField.append(crossswordList.get(i).getClue() + " " + crossswordList.get(i).getNumberOfLettersInAnswer() + "\n");
                //Debug informations
                cluesTextField.append(crossswordList.get(i).getAnswer() + " row: "+ crossswordList.get(i).getRow() + " col: "+ crossswordList.get(i).getCol() + "\n");
            }
        }

        //add a space in between the two
        cluesTextField.append("\n");

        // Put the across clues on the screen
        cluesTextField.append("Across:" + "\n");
        for (int i = 0; i < crossswordList.size(); ++i) {
            //Put the clue number in text
            if(!(crossswordList.get(i).getIsDown())) {
                cluesTextField.append(crossswordList.get(i).getClueNumber() + ". ");
                //put the Clue in the text
                cluesTextField.append(crossswordList.get(i).getClue() + "\n");
                //Debug information
                cluesTextField.append(crossswordList.get(i).getAnswer() + " " + crossswordList.get(i).getNumberOfLettersInAnswer() + "\n");
            }
        }
    }
}
