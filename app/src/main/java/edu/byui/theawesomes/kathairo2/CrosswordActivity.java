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
import java.util.Arrays;

public class CrosswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Word test = new Word();
        //Boolean[][] testInput = new Boolean[21][2];
        //Arrays.fill(testInput, Boolean.FALSE);
        Boolean[][] testInput = {{false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}};
        testInput[1][1] =  true;

        for(int r=1; r<=2; r++) {
            for (int c = 1; c <= 21; c++) {
                String buttonID = "r" + r + "c" + c;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                TextView textView = (TextView) findViewById(resID);

                textView.setText("");
                textView.setMaxWidth(30);
                textView.setMaxHeight(45);
                textView.setWidth(30);
                textView.setHeight(50);
                textView.setX(c);
                textView.setY(r);
                textView.setTextSize(40);
                if(testInput[r][c] == true){
                    textView.setText("E");
                }
/**/
            }
        }

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


        /*
        Intent i = new Intent(this, CluesActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
        /**/
    }

}
