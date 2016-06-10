package edu.byui.theawesomes.kathairo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //hola cara bola
    private String userName;
    private int number = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int getNumber(){
        return this.number;
    }

    public  boolean setUserName(String userName){
        this.userName = userName;
        if(this.userName != null)
        return true;
        else return false;
    }

}
