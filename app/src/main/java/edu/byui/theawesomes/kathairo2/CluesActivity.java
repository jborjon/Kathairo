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
         */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            crossword = extras.getParcelable("CrosswordObject");
        }
        else {
            crossword = new Crossword();
            try {
                CrosswordXmlParser crosswordXmlParser = new CrosswordXmlParser();
                AssetManager assetManager = getAssets();
                crossword.setCrosswordList(crosswordXmlParser.parse(assetManager.open("crossword.xml")));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }

        // Display the clues
        displayClues(crossword);
    }

    public void newGameOnClick(View v){
            Intent intent = new Intent(getBaseContext(), CrosswordActivity.class);
        try {
            intent.putExtra("CrosswordObject", (Parcelable) crossword);
        }
        catch (Exception e){
            Log.e("intent put Extra",e.toString());
        }
            startActivity(intent);
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
//                cluesTextField.append(crossswordList.get(i).getAnswer() + " row: "+ crossswordList.get(i).getRow() + " col: "+ crossswordList.get(i).getCol() + "\n");
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
//                cluesTextField.append(crossswordList.get(i).getAnswer() + " row: "+ crossswordList.get(i).getRow() + " col: "+ crossswordList.get(i).getCol() + "\n");
            }
        }
    }
}
