package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Chronometer;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CrosswordActivity extends AppCompatActivity {

    //Perhaps when you click on the text box it becomes editable
    //Setting the background to black for nonediitable and white for editiable
    //

    // The timer!
    Chronometer timer;

    //Which of these are valid?
    Boolean[][] validInput = new Boolean[16][22];
    Character[][] solvedCrossword = new Character[16][22];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Associate the chronometer with the on-page timer
        timer = (Chronometer) findViewById(R.id.puzzleTimer);

        Word test = new Word();

        setCrosswordValidInput();
        setCrosswordTextBoxes();

        // Start the timer
        timer.start();

    }

    public void mainMenuOnClick(View v){
        Intent i = new Intent(this, MainScreen.class);
        //i.putExtras(bundle);
        startActivity(i);
    }

    public void checkIfSolvedOnClick(View v) {
        //checks if it's solved
        for (int r = 1; r <= 2; r++) {
            for (int c = 1; c <= 21; c++) {
                if(validInput[r][c] == true) {
                    String buttonID = "r" + r + "c" + c;
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    EditText textView = (EditText) findViewById(resID);
                    if(textView.getText().toString().equals("d")){

                    }
                }
            }
        }
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

    public void setCrosswordTextBoxes(){
        solvedCrossword[1][7] = 'C';
        for(int r = 1; r <= 15; r++) {
            for (int c = 1; c <= 21; c++) {
                String buttonID = "r" + r + "c" + c;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                EditText textView = (EditText) findViewById(resID);

                formatTextBoxes(textView,r,c);

                if(validInput[r][c] == true){
                    textView.setEnabled(Boolean.TRUE);
                    textView.setBackgroundColor(Color.WHITE);
                    textView.setTextColor(Color.BLACK);

                    textView.setText("E");
                }
/**/
            }
        }
    }

    public void formatTextBoxes(TextView textView, int r, int c){
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(Color.BLACK);

        textView.setEnabled(Boolean.TRUE);
        textView.setBackgroundColor(Color.BLACK);
        textView.setText("");
        textView.setMaxLines(1);

        textView.setMaxWidth(30);
        textView.setMaxHeight(50);
        textView.setWidth(30);
        textView.setHeight(50);
        textView.setX(c);
        textView.setY(r);
        textView.setTextSize(40);
        textView.setEnabled(Boolean.FALSE);
    }

    public void setCrosswordValidInput(){

        for(int i = 0; i <= validInput.length-1; i++)
        {
            Arrays.fill(validInput[i], Boolean.FALSE);
        }
        // Which cells contain a letter?

        // Row 1
        validInput[1][7] = Boolean.TRUE;


        // Row 2
        validInput[2][7] = Boolean.TRUE;
        validInput[2][8] = Boolean.TRUE;
        validInput[2][9] = Boolean.TRUE;
        validInput[2][10] = Boolean.TRUE;
        validInput[2][11] = Boolean.TRUE;

        // Row 3
        validInput[3][7] = Boolean.TRUE;

        // Row 4
        validInput[4][1] = Boolean.TRUE;
        validInput[4][2] = Boolean.TRUE;
        validInput[4][3] = Boolean.TRUE;
        validInput[4][4] = Boolean.TRUE;
        validInput[4][5] = Boolean.TRUE;
        validInput[4][6] = Boolean.TRUE;
        validInput[4][7] = Boolean.TRUE;
        validInput[4][8] = Boolean.TRUE;
        validInput[4][9] = Boolean.TRUE;
        validInput[4][10] = Boolean.TRUE;
        validInput[4][11] = Boolean.TRUE;
        validInput[4][12] = Boolean.TRUE;
        validInput[4][13] = Boolean.TRUE;
        validInput[4][14] = Boolean.TRUE;
        validInput[4][15] = Boolean.TRUE;

        // Row 5
        validInput[5][7] = Boolean.TRUE;
        validInput[5][13] = Boolean.TRUE;

        // Row 6
        validInput[6][4] = Boolean.TRUE;
        validInput[6][7] = Boolean.TRUE;
        validInput[6][13] = Boolean.TRUE;
        validInput[6][18] = Boolean.TRUE;

        // Row 7
        validInput[7][4] = Boolean.TRUE;
        validInput[7][7] = Boolean.TRUE;
        validInput[7][11] = Boolean.TRUE;
        validInput[7][12] = Boolean.TRUE;
        validInput[7][13] = Boolean.TRUE;
        validInput[7][14] = Boolean.TRUE;
        validInput[7][15] = Boolean.TRUE;
        validInput[7][16] = Boolean.TRUE;
        validInput[7][17] = Boolean.TRUE;
        validInput[7][18] = Boolean.TRUE;
        validInput[7][19] = Boolean.TRUE;
        validInput[7][20] = Boolean.TRUE;
        validInput[7][21] = Boolean.TRUE;

        // Row 8
        validInput[8][4] = Boolean.TRUE;
        validInput[8][7] = Boolean.TRUE;
        validInput[8][13] = Boolean.TRUE;
        validInput[8][16] = Boolean.TRUE;
        validInput[8][18] = Boolean.TRUE;

        // Row 9
        validInput[9][4] = Boolean.TRUE;
        validInput[9][7] = Boolean.TRUE;
        validInput[9][13] = Boolean.TRUE;
        validInput[9][18] = Boolean.TRUE;

        // Row 10
        validInput[10][4] = Boolean.TRUE;
        validInput[10][5] = Boolean.TRUE;
        validInput[10][6] = Boolean.TRUE;
        validInput[10][7] = Boolean.TRUE;
        validInput[10][8] = Boolean.TRUE;
        validInput[10][9] = Boolean.TRUE;
        validInput[10][13] = Boolean.TRUE;
        validInput[10][18] = Boolean.TRUE;

        // Row 11
        validInput[11][7] = Boolean.TRUE;
        validInput[11][13] = Boolean.TRUE;
        validInput[11][18] = Boolean.TRUE;

        // Row 12
        validInput[12][5] = Boolean.TRUE;
        validInput[12][6] = Boolean.TRUE;
        validInput[12][7] = Boolean.TRUE;
        validInput[12][8] = Boolean.TRUE;
        validInput[12][9] = Boolean.TRUE;
        validInput[12][10] = Boolean.TRUE;
        validInput[12][13] = Boolean.TRUE;
        validInput[12][18] = Boolean.TRUE;

        // Row 13
        validInput[13][13] = Boolean.TRUE;

        // Row 14
        validInput[14][12] = Boolean.TRUE;
        validInput[14][13] = Boolean.TRUE;
        validInput[14][14] = Boolean.TRUE;
        validInput[14][15] = Boolean.TRUE;

        // Row 15
        validInput[15][13] = Boolean.TRUE;
    }

}
/***************
 * garage collection
 ****************

 Boolean[][] validInput = {{false},
 {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
 {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}};
 validInput[1][1] =  true;

 **************
 *end
 *********/