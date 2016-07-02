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

        // Bogus data!
        ArrayList<String> bogusDownData = new ArrayList<String>();
        ArrayList<String> bogusAcrossData = new ArrayList<String>();

CrossWord crossWord = new CrossWord();
        crossWord.addWord("hello",1);
        crossWord.getCrosswordList();

        // Get the appropriate text field
        TextView cluesTextField = (TextView) findViewById(R.id.cluesList);

        // DELETE the following, it's just for testing
        bogusDownData.add("You need to start learning to dance before your _______  in order to learn to dance. (5 letters)");
        bogusDownData.add("name");
        bogusDownData.add("is");
        bogusDownData.add("Inigo");
        bogusDownData.add("Montoya");

        bogusAcrossData.add("In the 1600s dancing was very prevalent. Today, dancing is done ______");
        bogusAcrossData.add("prepare");
        bogusAcrossData.add("to");
        bogusAcrossData.add("die");


        // Put the down clues on the screen
        cluesTextField.append("Down:" + "\n");
        for (int i = 0; i < bogusDownData.size(); ++i) {
            //we will have to access the clue number later... once we have it
            // Add a list number, starting with 1, followed by the clue
            cluesTextField.append(Integer.toString(i + 1) + ". " + bogusDownData.get(i) + "\n");
        }

        cluesTextField.append("\n");

        // Put the across clues on the screen
        cluesTextField.append("\nAcross:" + "\n");
        for (int i = 0; i < bogusAcrossData.size(); ++i) {
            //we will have to access the clue number later... once we have it
            // Add a list number, starting with 1, followed by the clue
            cluesTextField.append(Integer.toString(i + 1) + ". " + bogusAcrossData.get(i) + "\n");
        }
    }
}
