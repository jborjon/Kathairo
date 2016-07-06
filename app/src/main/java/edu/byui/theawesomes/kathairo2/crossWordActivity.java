package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class crossWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Word test = new Word();
        test.setAnswer("hello");


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

}
