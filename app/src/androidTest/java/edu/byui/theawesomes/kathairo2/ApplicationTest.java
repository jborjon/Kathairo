package edu.byui.theawesomes.kathairo2;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    /****************************************************
     *
     *
     *****************************************************/
    public ApplicationTest() {
        super(Application.class);
    }

    /****************************************************
     *
     *
     *****************************************************/
    public void test() throws Exception {
       CharacterCell test = new CharacterCell();
        test.setCharacter("a");
        assertEquals("a", test.getCharacter());
        String characterInCell = "Character in cel is " + test.getCharacter();
        Log.i("Felipes", characterInCell);







       // System.out.println(testWord.getword());
        //assertEquals(" test",testWord.getword());
    }
}

