package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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