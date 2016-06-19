package edu.byui.theawesomes.kathairo2;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;

import java.util.ArrayList;

/**
 * Created by Jordan on 6/8/16.
 *
 */
public class GridPanelTest extends ApplicationTestCase<Application> {


    private int width;
    //private int height;
    //private Crossword crossword;
    //private CharacterCell focus;
    private ArrayList list;
    private boolean currentlyDown;
    //private Cell cell;

    public GridPanelTest(){
        super(Application.class);
        width = 4;
    }
    public void
    testSetHighlightedClue(){
        assert(setHighlightedClue() == true);
        boolean test =  setHighlightedClue();
        width = 5;
        assertEquals(test, setHighlightedClue());
    }
    public void focusNextCell(){

    }
    public void paint() {

    }
    public boolean setHighlightedClue(){
        if(width == 5) {
            return true;
        }
        else {
            return  false;
        }

    }

}