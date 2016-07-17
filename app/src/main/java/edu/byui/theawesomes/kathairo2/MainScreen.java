package edu.byui.theawesomes.kathairo2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /****************************************************
     * This sets changes the activity to the Crossword
     * @param v View
     *****************************************************/
    public void newGameOnClick(View v){
        Intent intent = new Intent(this, CrosswordActivity.class);
        Log.e("SCREWED","hagdkjhskgj");
        startActivity(intent);
    }

    /****************************************************
     * This sets changes the activity to the about page
     * @param v View
     *****************************************************/
    public void aboutOnClick(View v){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
