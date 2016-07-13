package edu.byui.theawesomes.kathairo2;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

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
        /*for(int i=1; i<=2; i++) {
            String buttonID = "testInput" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            TextView textView = (TextView)   findViewById(resID);

            textView.setText("");
            textView.setMaxWidth(20);
            textView.setMaxHeight(45);
            textView.setWidth(20);
            textView.setX(50*(i%15));
            textView.setY(50*((i/15)));
        }
        /*
        findViewById(R.id.testInput1);

        TextView textView = (TextView) findViewById(R.id.testInput1);
        textView.setText("");
        textView.setMaxWidth(20);
        textView.setMaxHeight(45);
        textView.setWidth(20);
        textView.setX(50);
        textView.setY(50);*/
        Intent i = new Intent(this, CrosswordActivity.class);
        //i.putExtras(bundle);
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
