package edu.byui.theawesomes.kathairo2;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.ArrayList;

/**
 * Created by Joseph H. Borjon on 6/8/2016.
 */
public class SolvedLog extends ApplicationTestCase<Application> {

    public ArrayList<Clue> solvedClue;

    public SolvedLog() {
        super(Application.class);
    }

    public void test_addSolvedClue(Clue clue) {
        // Since there was no return value to test, I made up two tests cases
        // with placeholder variables to learn how the Android test tools work
        boolean isTrue = true;

        assertFalse(isTrue);
    }

    public void test_removeAllSolvedClues() {
        int value = 777;

        assertNull(value);
    }
}
