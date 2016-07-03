package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class cluesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clues);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Display the clues
        displayClues();
    }
    public void mainMenuOnClick(View v){
        Intent i = new Intent(this, mainScreen.class);
        //i.putExtras(bundle);
        startActivity(i);
    }
    public void newGameOnClick(View v){
        Intent i = new Intent(this, crossWordActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
    }

    public void cluesOnClick(View v){
        Intent i = new Intent(this, cluesActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
    }


    protected void displayClues() {

        //later this data will be passed in
        CrossWord crossWordDown = new CrossWord();
        crossWordDown.addWord("You need to start learning to dance before your _______  in order to learn to dance. ",1);

        CrossWord crossWordAcross = new CrossWord();
        crossWordAcross.addWord("In the 1600s dancing was very prevalent. Today, dancing is done ______",8);

        //Declare the variables they will be stored in
        List<Word> downClues = new ArrayList<Word>();
        List<Word> acrossClues = new ArrayList<>();

        //set the variables
        downClues = crossWordDown.getCrosswordList();
        acrossClues = crossWordAcross.getCrosswordList();

        // Get the appropriate text field
        TextView cluesTextField = (TextView) findViewById(R.id.cluesList);

        // Put the down clues on the screen
        cluesTextField.append("Down:" + "\n");
        for (int i = 0; i < downClues.size(); ++i) {
            //Put the clue number in text
           cluesTextField.append(Integer.toString(downClues.get(i).getNumberOfTheWord())+". ");
            //put the Clue in the text
            cluesTextField.append(downClues.get(i).getWord());
            //put the amount of letters in the answer
            cluesTextField.append("("+downClues.get(i).getNumberOfCharactersInTheWord()+" letters)"+"\n");
        }

        cluesTextField.append("\n");

        // Put the across clues on the screen
        cluesTextField.append("Across:" + "\n");
        for (int i = 0; i < acrossClues.size(); ++i) {
            //Put the clue number in text
            cluesTextField.append(Integer.toString(acrossClues.get(i).getNumberOfTheWord())+". ");
            //put the Clue in the text
            cluesTextField.append(acrossClues.get(i).getWord());
            //put the amount of letters in the answer
            cluesTextField.append("("+acrossClues.get(i).getNumberOfCharactersInTheWord()+" letters)"+"\n");
        }
    }
}
