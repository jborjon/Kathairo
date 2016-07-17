package edu.byui.theawesomes.kathairo2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Chronometer;

public class CrosswordActivity extends AppCompatActivity {

    protected Chronometer timer;
    private Crossword crossword;
    private MediaPlayer bkgrmsc;
    private Switch switchMusic;
    private boolean isMusicOn = true;

    // Used to determine which boxes are being used in the current crossword
    private Boolean[][] validInput;

    // Used to determine which answers are valid
    private Character[][] validAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Associate the chronometer with the on-page timer
        timer = (Chronometer) findViewById(R.id.puzzleTimer);

        //Load the crossword
        AssetManager assetManager = getAssets();
        crossword = new Crossword(assetManager);

        //Draw the crossword
        setCrosswordTextBoxes();

        // Start the timer
        timer.start();

        switchMusic =(Switch) findViewById(R.id.switch1);
        bkgrmsc = MediaPlayer.create(this,R.raw.discomfort);
        bkgrmsc.setLooping(true);
        if(isMusicOn) {
            bkgrmsc.start();
        }
    }


    public void setMusic(View v){
        if(switchMusic.isChecked()) {
            isMusicOn = false;
            bkgrmsc.pause();
        }
        else{
            isMusicOn = true;
            bkgrmsc.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isMusicOn) {
            bkgrmsc.pause();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(isMusicOn) {
            bkgrmsc.start();
        }
    }

    /****************************************************
     * This sets changes the activity to the Main menu
     *
     * @param v View
     *****************************************************/
    public void mainMenuOnClick(View v) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    /****************************************************
     * This sets changes the activity to the Main menu
     *
     * @param v View
     *****************************************************/
    public void cluesOnClick(View v) {
        Intent intent = new Intent(this, CluesActivity.class);
        startActivity(intent);
    }

    /****************************************************
     * This checks if the user has solved the puzzle
     * it erases any wrong answers and changes the wrong
     * answers to red and the correct answers to green
     *
     * @param v View
     *****************************************************/
    public void checkIfSolvedOnClick(View v) {
        //Don't want to waste the users time
        timer.stop();

        //Set the pertinent variables
        validAnswer = crossword.getValidAnswer();
        validInput = crossword.getValidInput();
        Boolean isSolved = Boolean.TRUE;

        //Loop through the entire puzzle
        for (int r = 1; r <= 15; r++) {
            for (int c = 1; c <= 21; c++) {

                //check to make sure this can have text in it
                if (validInput[r][c]) {

                    // get the string ID
                    String buttonID = "r" + r + "c" + c;
                    // get the resource ID
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    //Finally get the textview
                    EditText textView = (EditText) findViewById(resID);

                    if (textView != null) {

                        String textToCheck = textView.getText().toString().toUpperCase();

                        //Check to see if there is a mismatch
                        if (!(textToCheck.equals(Character.toString(validAnswer[r][c])))) {

                            isSolved = false;
                            textView.setBackgroundColor(Color.RED);
                            textView.setText("");

                        } else {

                            textView.setBackgroundColor(Color.GREEN);

                        }

                    }
                }
            }
        }

        //If isSolved is still true they must have solved the puzzle!
        if (isSolved) {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Congratualtions you finished!");
            builder1.setCancelable(true);

            builder1.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

        //If isSolved is false they must not have solved the puzzle!
        else {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Sorry you aren't quite done yet!");
            builder1.setCancelable(true);

            builder1.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    timer.start();
                    dialog.cancel();
                }
            });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    /****************************************************
     * This sets up the crossword, moves all the
     * textboxes into their places and sets up the
     * listeners
     *****************************************************/
    public void setCrosswordTextBoxes() {

        validInput = crossword.getValidInput();
        validAnswer = crossword.getValidAnswer();

        for (int r = 1; r <= 15; r++) {
            for (int c = 1; c <= 21; c++) {

                formatDefaultTextBoxes(r, c);

                if (validInput[r][c]) {

                    formatEditableTextBoxes(r, c);

                }
            }
        }
    }


    /****************************************************
     * This formats the crossword numbers on the boxes
     *****************************************************/
    public void formatNumberBoxes(TextView textView, int count) {
        textView.setText(Integer.toString(count));
    }

    public void formatEditableTextBoxes(int r, int c) {

        //Find the textviews
        String buttonID = "r" + r + "c" + c;
        final int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        final EditText textView = (EditText) findViewById(resID);


        if (textView != null) {

            textView.setEnabled(Boolean.TRUE);
            textView.setBackgroundColor(Color.WHITE);
            textView.setTextColor(Color.BLACK);
            textView.setText("");

            //needed so we can access them in the listeners
            final String validAnswerString = Character.toString(validAnswer[r][c]);


            /****************************************************
             * This sets the onTouch listener, which change the
             * text to yellow and erase the text for new input
             *****************************************************/
            textView.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    String textToCheck = textView.getText().toString().toUpperCase();

                    if (!(textToCheck.equals(validAnswerString))) {

                        textView.setBackgroundColor(Color.YELLOW);
                        textView.setText("");

                    }

                    return false;

                }
            });

            /****************************************************
             * This sets the onFocus listener, which change the
             * text to white after the focus change
             *****************************************************/
            textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {

                    if (!hasFocus) {

                        String textToCheck = textView.getText().toString().toUpperCase();

                        if (!(textToCheck.equals(validAnswerString))) {

                            textView.setBackgroundColor(Color.WHITE);

                        }
                    }
                }
            });

        }
    }

    /****************************************************
     * This intializes the formating of the textboxes
     *****************************************************/
    public void formatDefaultTextBoxes(int r, int c) {

        //Find the textviews
        String buttonID = "r" + r + "c" + c;
        final int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        EditText textView = (EditText) findViewById(resID);

        if (textView != null) {
            textView.setTextColor(Color.WHITE);

            textView.setBackgroundColor(Color.BLACK);

            textView.setEnabled(Boolean.TRUE);
            textView.setBackgroundColor(Color.BLACK);
            textView.setText("");
            textView.setMaxLines(1);

            Display dp = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            dp.getSize(size);

            int width = size.x;
            int height = size.y;

            textView.setMaxWidth((width / 30));
            textView.setMaxHeight(height / 30);
            textView.setWidth((width / 30));
            textView.setHeight((height / 35));
            textView.setX(c);
            textView.setY(r);
            textView.setTextSize(20);
            textView.setEnabled(Boolean.FALSE);
        }
    }
}