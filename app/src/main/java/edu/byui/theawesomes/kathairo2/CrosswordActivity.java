package edu.byui.theawesomes.kathairo2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Chronometer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CrosswordActivity extends AppCompatActivity {

    //To work on:
    //Numbers on the crossword
    //Finalize the solver and make it look nice (have the colors work)
    // How to transfer the crossword between things.

    // The timer!
    Chronometer timer;

    //Which of these are valid?
    Boolean[][] validInput = new Boolean[16][22];
    Character[][] validAnswer = new Character[16][22];

    private List<Word> words = new ArrayList<Word>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Associate the chronometer with the on-page timer
        timer = (Chronometer) findViewById(R.id.puzzleTimer);

        Word test = new Word();

        Crossword crossword = new Crossword();
        //Below is testing to get the xml file to work
        try {
            CrosswordXmlParser crosswordXmlParser = new CrosswordXmlParser();
            AssetManager assetManager = getAssets();
            crossword.setCrosswordList(crosswordXmlParser.parse(assetManager.open("crossword.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        words = crossword.getCrosswordList();
        setCrosswordValidInput(crossword);
        setCrosswordTextBoxes();
        setValidAnswers();
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
        Boolean isSolved = Boolean.TRUE;
        for (int r = 1; r <= 15; r++) {
            for (int c = 1; c <= 21; c++) {
                if (validInput[r][c] == true) {
                    String buttonID = "r" + r + "c" + c;
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    EditText textView = (EditText) findViewById(resID);
                    if ( r == 6 && c == 4) {
                            int test = 0;
                       if (((textView.getText().toString().toUpperCase()).equals("D"))) {
                            Log.i("Checkifsolved", "IfStatement");
                            textView.setBackgroundColor(Color.GREEN);
                           for(int i = 1; i < words.get(0).getNumberOfLettersInAnswer(); i++) {
                               Log.i("Checkifsolved", "I: " + i);

                               String ID = "r" + (r + i) + "c" + c;
                               int resoID = getResources().getIdentifier(ID, "id", getPackageName());
                               Log.i("Checkifsolved", "Idloop: " + ID);
                               EditText textView1 = (EditText) findViewById(resoID);
                               Log.i("Checkifsolved", "textuser: " + textView1.getText());

                               Log.i("Checkifsolved", "textAnswer " + words.get(0).getLetter(i));
                               if(words.get(0).getLetter(i).equals(textView1.getText().toString())) {
                                   textView1.setBackgroundColor(Color.GREEN);
                                   test++;

                               }
                               else
                               {textView1.setBackgroundColor(Color.RED);}
                                   Log.i("Checkifsolved", "I: " + words.get(0).getNumberOfLettersInAnswer());
                               Log.i("Checkifsolved", "bool tiene que ser 4: " + test);


                               }


                        }
                    isSolved = false;

                        //textView.setText("");
                    }
                    else{
                        //textView.setBackgroundColor(Color.RED);
                    }

                }
            }
        }
isSolved = true;
        if(isSolved == true){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Congratualtions your time was: "+timer.getText().toString() + "!");
            builder1.setCancelable(true);

            builder1.setNeutralButton("Ok",  new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            //for when we have the play again option
            /*
            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            */
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Sorry you aren't quite done yet!");
            //builder1.setMessage(words.get(0).getAnswer());
            builder1.setCancelable(true);

            builder1.setNeutralButton("Ok",  new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
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
        /**/
    }

    public void setCrosswordTextBoxes(){
        for(int r = 1; r <= 15; r++) {
            for (int c = 1; c <= 21; c++) {
                String buttonID = "r" + r + "c" + c;
                final int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                EditText textView = (EditText) findViewById(resID);

                formatTextBoxes(textView,r,c);
                //once we get the crossword in we can check to see if the rows match up
                //if((crossswordList.get(i).getRow() == r &&  crossswordList.get(i).getRow() == c))
                //then we have it loop and fill out all the rest of the word and then going back
                //no I don't think this will work I will leave it hear in case we want to do it later though
                if(validInput[r][c] == true){
                    assert textView != null;
                    textView.setEnabled(Boolean.TRUE);
                    textView.setBackgroundColor(Color.WHITE);
                    textView.setTextColor(Color.BLACK);
                    textView.setText("");
                    final TextView buttonT = (TextView) findViewById(resID);
                    final TextView textViewT = (TextView) findViewById(resID);
                    final int finalC = c;
                    final int finalR = r;
/* for when we want to add the type and it focuses on the next one
                    buttonT.addTextChangedListener(new TextWatcher() {
                                                      public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                          // TODO Auto-generated method stub
                                                          if(textViewT.getText().toString().length()==1)
                                                          {
                                                              textViewT.clearFocus();
                                                             // textViewTN.requestFocus();
                                                              textViewTN.setCursorVisible(true);

                                                          }
                                                      }
*/
                    buttonT.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            final TextView textView = (TextView) findViewById(resID);
                            if (!((textView.getText().toString().toUpperCase()).equals(Character.toString(validAnswer[finalR][finalC])))) {
                                textView.setBackgroundColor(Color.YELLOW);
                                textView.setText("");
                            }
                            return false;
                        }
                    });

                    //random commment!
                    buttonT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus ){
                                if (!((textViewT.getText().toString().toUpperCase()).equals(Character.toString(validAnswer[finalR][finalC])))) {
                                    textViewT.setBackgroundColor(Color.WHITE);
                                }
                            }
                        }

                    });


                }
/**/
            }
        }
    }

    public void formatNumberBoxes(TextView textView, int count){
        textView.setText(Integer.toString(count));
    }

    public void formatTextBoxes(TextView textView, int r, int c){
        Display display = getWindowManager().getDefaultDisplay();

        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(Color.BLACK);

        textView.setEnabled(Boolean.TRUE);
        textView.setBackgroundColor(Color.BLACK);
        textView.setText("");
        textView.setMaxLines(1);

        textView.setMaxWidth(((display.getWidth())/40));
        textView.setMaxHeight(((display.getHeight())/35));
        textView.setWidth(((display.getWidth())/40));
        textView.setHeight(((display.getHeight())/35));
        textView.setX(c);
        textView.setY(r);
        textView.setTextSize(20);
        textView.setEnabled(Boolean.FALSE);
    }

    public void setValidAnswers(){


        // Row 1
        validAnswer[1][7] = 'C';


        // Row 2
        validAnswer[2][7] = 'O';
        validAnswer[2][8] = 'F';
        validAnswer[2][9] = 'T';
        validAnswer[2][10] = 'E';
        validAnswer[2][11] = 'N';

        // Row 3
        validAnswer[3][7] = 'N';
        validAnswer[3][13] = 'S';

        // Row 4
        validAnswer[4][1] = 'P';
        validAnswer[4][2] = 'E';
        validAnswer[4][3] = 'R';
        validAnswer[4][4] = 'F';
        validAnswer[4][5] = 'E';
        validAnswer[4][6] = 'C';
        validAnswer[4][7] = 'T';
        validAnswer[4][8] = 'P';
        validAnswer[4][9] = 'R';
        validAnswer[4][10] = 'A';
        validAnswer[4][11] = 'C';
        validAnswer[4][12] = 'T';
        validAnswer[4][13] = 'I';
        validAnswer[4][14] = 'C';
        validAnswer[4][15] = 'E';

        // Row 5
        validAnswer[5][7] = 'E';
        validAnswer[5][13] = 'M';

        // Row 6
        validAnswer[6][4] = 'D';
        validAnswer[6][7] = 'M';
        validAnswer[6][13] = 'P';
        validAnswer[6][18] = 'U';

        // Row 7
        validAnswer[7][4] = 'E';
        validAnswer[7][7] = 'P';
        validAnswer[7][11] = 'W';
        validAnswer[7][12] = 'I';
        validAnswer[7][13] = 'L';
        validAnswer[7][14] = 'L';
        validAnswer[7][15] = 'I';
        validAnswer[7][16] = 'N';
        validAnswer[7][17] = 'G';
        validAnswer[7][18] = 'N';
        validAnswer[7][19] = 'E';
        validAnswer[7][20] = 'S';
        validAnswer[7][21] = 'S';

        // Row 8
        validAnswer[8][4] = 'A';
        validAnswer[8][7] = 'O';
        validAnswer[8][13] = 'E';
        validAnswer[8][16] = 'O';
        validAnswer[8][18] = 'E';

        // Row 9
        validAnswer[9][4] = 'T';
        validAnswer[9][7] = 'R';
        validAnswer[9][13] = 'C';
        validAnswer[9][18] = 'E';

        // Row 10
        validAnswer[10][4] = 'H';
        validAnswer[10][5] = 'U';
        validAnswer[10][6] = 'M';
        validAnswer[10][7] = 'A';
        validAnswer[10][8] = 'N';
        validAnswer[10][9] = 'S';
        validAnswer[10][13] = 'O';
        validAnswer[10][18] = 'D';

        // Row 11
        validAnswer[11][7] = 'R';
        validAnswer[11][13] = 'M';
        validAnswer[11][18] = 'E';

        // Row 12
        validAnswer[12][5] = 'R';
        validAnswer[12][6] = 'H';
        validAnswer[12][7] = 'Y';
        validAnswer[12][8] = 'T';
        validAnswer[12][9] = 'H';
        validAnswer[12][10] = 'M';
        validAnswer[12][13] = 'P';
        validAnswer[12][18] = 'D';

        // Row 13
        validAnswer[13][13] = 'L';

        // Row 14
        validAnswer[14][12] = 'Z';
        validAnswer[14][13] = 'E';
        validAnswer[14][14] = 'R';
        validAnswer[14][15] = 'O';

        // Row 15
        validAnswer[15][13] = 'X';
        
    }

    public void setCrosswordValidInput(Crossword crossword) {

        //intialize the values to false because it's default
        for (int i = 0; i <= validInput.length - 1; i++) {
            Arrays.fill(validInput[i], Boolean.FALSE);
        }

        //we are going to go through all the words in the crossword
        for (int i = 0; i < crossword.getCrosswordList().size(); i++) {
            //so we don't have to keep calling this function
            Log.i("get Crossword List", Integer.toString(crossword.getCrosswordList().size()));
            Word word = crossword.getCrosswordList().get(i);

            //assign the row for this word
            int row = word.getRow();
            //assign the col for this word
            int col = word.getCol();

            Log.i("Set validA",word.getAnswer());
            Log.i("Set validD",Boolean.toString(word.getIsDown()));
//            Log.i("Set validR",Integer.toString(row));
//            Log.i("Set validC",Integer.toString(col));
//            Log.i("Set validL",Integer.toString(word.getNumberOfLettersInAnswer()));
//            Log.i("Set validA",word.getAnswer());
            //check to see if this is a word that goes across or down.
            if(word.getIsDown())
            {
                //start at the parent row and goes down to the end
                for (int r = row; r < word.getNumberOfLettersInAnswer()+row; r++) {
                    //Log.i("Set validSDR",Integer.toString(r));
                    //Log.i("Set validSDC",Integer.toString(col));
                    //Log.i("Set validSVI",Boolean.toString(validInput[r-1][col-1]));
                    //Log.i("Set validSDL",Integer.toString(word.getNumberOfLettersInAnswer()));
                    //collumn stays the same while the row goes down
                    validInput[r][col] = true;
                }
            }
            else
            {
                //start at the parent col and goes across to the end
                for(int c = col; c < word.getNumberOfLettersInAnswer()+col; c++) {
                    //Log.i("Set validSAR",Integer.toString(row));
                    Log.i("Set validSAC",Integer.toString(c));
                    //Log.i("Set validSAL",Integer.toString(word.getNumberOfLettersInAnswer()));

                    //collumn stays the same while the collumn goes down
                    validInput[row][c] = true;
                }
            }
        }

//        for(int r = 0; r <=5; r++) {
//            for (int c = 0; c <= 5; c++) {

//            }
//        }
        // Which cells contain a letter?
/*
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
        validInput[3][13] = Boolean.TRUE;

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
        validInput[15][13] = Boolean.TRUE;*/
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