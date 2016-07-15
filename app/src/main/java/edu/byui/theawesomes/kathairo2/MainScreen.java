package edu.byui.theawesomes.kathairo2;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class MainScreen extends AppCompatActivity {

    Crossword crossword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crossword = new Crossword();
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public void newGameOnClick(View v){
        Intent intent = new Intent(getBaseContext(), CrosswordActivity.class);
        intent.putExtra("CrosswordObject", (Parcelable) crossword);
        startActivity(intent);
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
