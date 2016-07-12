package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CrosswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Word test = new Word();
        test.setAnswer("1234");

       // TextView testview = (TextView) findViewById(R.id.test);
        TextView A1L1 = (TextView) findViewById(R.id.A1L1);
        TextView A1L2 = (TextView)findViewById(R.id.A1L2);

       // testview.setText("esta es");
        CharacterCell word1 = new CharacterCell();
        word1.setCharacter("K");
        A1L1.setText(test.getLetter(1));
        A1L2.setText("W");

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

}
