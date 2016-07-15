package edu.byui.theawesomes.kathairo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
//random comment to get this commited and pushed!
//random comment to get this commited and pushed!

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void mainMenuOnClick(View v){
        Intent i = new Intent(this, MainScreen.class);
        //i.putExtras(bundle);
        startActivity(i);
    }
}
