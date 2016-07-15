package edu.byui.theawesomes.kathairo2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
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
    protected Chronometer timer;
    private Crossword crossword;

    //Which of these are valid?
    private Boolean[][] validInput = new Boolean[16][22];
    private Character[][] validAnswer = new Character[16][22];

    private List<Word> words = new ArrayList<Word>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("test", "it made it");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Associate the chronometer with the on-page timer
        timer = (Chronometer) findViewById(R.id.puzzleTimer);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            crossword = extras.getParcelable("CrosswordObject");
        }
        else {
            crossword = new Crossword();
            try {
                CrosswordXmlParser crosswordXmlParser = new CrosswordXmlParser();
                AssetManager assetManager = getAssets();
                crossword.setCrosswordList(crosswordXmlParser.parse(assetManager.open("crossword.xml")));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        Log.i("test", "it made it2");
        setCrosswordValidInput(crossword);
        setCrosswordTextBoxes();
        setValidAnswers(crossword);
        Log.i("test", "it made it3");
        // Start the timer
        timer.start();
        Log.i("test", "it made it4");
    }

    public void mainMenuOnClick(View v){
            Intent intent = new Intent(getBaseContext(), CrosswordActivity.class);
            intent.putExtra("CrosswordObject", (Parcelable) crossword);
            startActivity(intent);
    }

    public void cluesOnClick(View v){
        Intent intent = new Intent(getBaseContext(), CrosswordActivity.class);
        intent.putExtra("CrosswordObject", (Parcelable) crossword);
        startActivity(intent);
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

    public void setValidAnswers(Crossword crossword){

        //intialize the values to false because it's default
        for (int i = 0; i <= validInput.length - 1; i++) {
            Arrays.fill(validInput[i], Boolean.FALSE);
        }

        //we are going to go through all the words in the crossword
        for (int i = 0; i < crossword.getCrosswordList().size(); i++) {

            //so we don't have to keep calling this function
            Word word = crossword.getCrosswordList().get(i);

            //assign the row for this word
            int row = word.getRow();
            //assign the col for this word
            int col = word.getCol();
            // create a variable so that we can loop through the word
            int count = 0;
            //check to see if this is a word that goes across or down.
            if(word.getIsDown())
            {
                //start at the parent row and goes down to the end
//                Log.i("validAnswer",word.getAnswer());
                for (int r = row; r < word.getNumberOfLettersInAnswer()+row; r++) {
                    //collumn stays the same while the row goes down
//                    Log.i("validAnswer",Character.toString(word.getLetter(count).charAt(0)));
                    validAnswer[r][col] = word.getLetter(count).charAt(0); //word.getLetter(count);
                    //Log.i("validAnswer",word.getLetter(count));
                    count++;

                }
            }
            else
            {
                //start at the parent col and goes across to the end
                for(int c = col; c < word.getNumberOfLettersInAnswer()+col; c++) {
                    //collumn stays the same while the collumn goes down
                   validAnswer[row][c] = word.getLetter(count).charAt(0);
                }
            }
        }
    }

    public void setCrosswordValidInput(Crossword crossword) {

        //intialize the values to false because it's default
        for (int i = 0; i <= validInput.length - 1; i++) {
            Arrays.fill(validInput[i], Boolean.FALSE);
        }

        //we are going to go through all the words in the crossword
        for (int i = 0; i < crossword.getCrosswordList().size(); i++) {
            //so we don't have to keep calling this function
            Word word = crossword.getCrosswordList().get(i);

            //assign the row for this word
            int row = word.getRow();
            //assign the col for this word
            int col = word.getCol();

            //check to see if this is a word that goes across or down.
            if(word.getIsDown())
            {
                //start at the parent row and goes down to the end
                for (int r = row; r < word.getNumberOfLettersInAnswer()+row; r++) {
                    //collumn stays the same while the row goes down
                    validInput[r][col] = true;
                }
            }
            else
            {
                //start at the parent col and goes across to the end
                for(int c = col; c < word.getNumberOfLettersInAnswer()+col; c++) {
                    //collumn stays the same while the collumn goes down
                    validInput[row][c] = true;
                }
            }
        }
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