package edu.byui.theawesomes.kathairo2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

//random comment to get this commited and pushed!

public class MainScreen extends AppCompatActivity {

    Crossword crossword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        crossword = new Crossword();
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void newGameOnClick(View v){
       Bundle bundle = new Bundle();

        Intent i = new Intent(this, CrosswordActivity.class);

        startActivity(i);/**/
    }

    public void aboutOnClick(View v){
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }

    public void cluesOnClick(View v){
        Intent i = new Intent(this, CluesActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
    }


}
