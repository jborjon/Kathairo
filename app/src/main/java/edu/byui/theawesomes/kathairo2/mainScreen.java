package edu.byui.theawesomes.kathairo2;

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
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

public class mainScreen extends AppCompatActivity {

    CrossWord crossword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        crossword = new Crossword();
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void newGameOnClick(View v){
        Intent i = new Intent(this, crossWordActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
    }

    public void aboutOnClick(View v){
        Intent i = new Intent(this, aboutActivity.class);
        startActivity(i);
    }

    public void cluesOnClick(View v){
        Intent i = new Intent(this, cluesActivity.class);
        //i.putExtras(bundle);
        startActivity(i);
    }


}
