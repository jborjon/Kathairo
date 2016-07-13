package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;

public class CrosswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Word test = new Word();

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
        TextView textViev2 = (TextView) findViewById(R.id.r1c1);
        textViev2.setText("1");
        for(int r=1; r<=2; r++) {
            for (int c = 1; c <= 21; c++) {
                TextView textViev3 = (TextView) findViewById(R.id.r2c21);
                textViev2.setText("r"+r+"c"+c);

                String buttonID = "r" + r + "c" + c;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                TextView textView = (TextView) findViewById(resID);
                textView.setText("H");
                textView.setMaxWidth(20);
                textView.setMaxHeight(45);
                textView.setWidth(20);
                textView.setX(10 * c);
                textView.setY(45 * r);
/**/
            }
        }

        /*
        Intent i = new Intent(this, CluesActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
        /**/
    }

}
