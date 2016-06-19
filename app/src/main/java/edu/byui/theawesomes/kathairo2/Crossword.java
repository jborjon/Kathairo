package edu.byui.theawesomes.kathairo2;

import java.util.ArrayList;

/**
 * Created by Joseph on 6/18/16.
 */
public class Crossword {
    public ArrayList<Clue> acrossClues;
    public ArrayList<Clue> downClues;
    public String title;
    public int size;
    public String userName;

    public int getSize() {
        // TODO: implement
        return size;
    }

    public String getTitle() {
        // TODO: implement
        return  title;
    }

    public ArrayList<Clue> getAcrossClues() {
        // TODO: implement
        return acrossClues;
    }

    public ArrayList<Clue> getDownClues() {
        // TODO: implement
        return downClues;
    }

    public ArrayList<Clue> getClues() {
        // TODO: implement
        return downClues;
    }

    public void setUserName(String userName) {
        // TODO: implement
        this.userName = userName;
    }

    public String getUserName() {
        // TODO: implement
        return  userName;
    }
}