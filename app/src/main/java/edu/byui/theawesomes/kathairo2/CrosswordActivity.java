package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CrosswordActivity extends AppCompatActivity {

    //Perhaps when you click on the text box it becomes editable
    //Setting the background to black for nonediitable and white for editiable
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Word test = new Word();
        Boolean[][] testInput = new Boolean[3][22];

        for(int i = 0; i <= testInput.length-1; i++)
        {
            Arrays.fill(testInput[i], Boolean.FALSE);
        }


        testInput[1][7] = Boolean.TRUE;
        testInput[2][7] = Boolean.TRUE;
        testInput[2][8] = Boolean.TRUE;
        testInput[2][9] = Boolean.TRUE;
        testInput[2][10] = Boolean.TRUE;
        for(int r = 1; r <= 2; r++) {
            for (int c = 1; c <= 21; c++) {
                String buttonID = "r" + r + "c" + c;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                EditText textView = (EditText) findViewById(resID);
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(Color.BLACK);

                textView.setEnabled(Boolean.TRUE);
                textView.setBackgroundColor(Color.BLACK);
                textView.setText("");
                textView.setMaxWidth(30);
                textView.setMaxHeight(45);
                textView.setWidth(30);
                textView.setHeight(50);
                textView.setX(c);
                textView.setY(r);
                textView.setTextSize(40);
                textView.setEnabled(Boolean.FALSE);

                if(testInput[r][c] == true){
                    textView.setEnabled(Boolean.TRUE);
                    textView.setBackgroundColor(Color.WHITE);
                    textView.setTextColor(Color.BLACK);

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
/***************
 * garage collection
 ****************

        Boolean[][] testInput = {{false},
                            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}};
        testInput[1][1] =  true;

 **************
 *end
 *********/