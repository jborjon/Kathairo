package edu.byui.theawesomes.kathairo2;

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


    protected void displayClues() {

        // Bogus data!
        ArrayList<String> bogusData = new ArrayList<String>();

        // Get the appropriate text field
        TextView cluesTextField = (TextView) findViewById(R.id.cluesList);

        // DELETE the following, it's just for testing
        bogusData.add("My");
        bogusData.add("name");
        bogusData.add("is");
        bogusData.add("Inigo");
        bogusData.add("Montoya");

        // Put the clues on the screen
        for (int i = 0; i < bogusData.size(); ++i) {
            // Add a list number, starting with 1, followed by the clue
            cluesTextField.append(Integer.toString(i + 1) + ". " + bogusData.get(i) + "\n");
        }
    }
}
