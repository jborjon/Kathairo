package edu.byui.theawesomes.kathairo2;

import android.app.Application;
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

        Word testWord = new Word();
        testWord.setWord("estoy loco");
        String display = testWord.getWord();
        Log.i("Fe", display);

        CrossWord crossWord = new CrossWord();

        crossWord.addWord("hola", 1);
        crossWord.addWord("como", 2);
        crossWord.addWord("estas", 3);
        crossWord.addWord("hoy?", 4);

        List<Word> words = new ArrayList<Word>();

        words = crossWord.getCrosswordList();
        Log.i("list", words.get(3).getWord());

        XMLPullParser XMLtest = new XMLPullParser();
        XMLtest.


       // System.out.println(testWord.getword());
        //assertEquals(" test",testWord.getword());
    }
}

