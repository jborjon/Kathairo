package edu.byui.theawesomes.kathairo2;

import java.util.ArrayList;

/**
 * Created by fmcho on 6/18/2016.
 */
public class SolvedLog {
    public ArrayList <Clue> myClues;

    public void addClueSolver(Clue toAdd){
        this.myClues.add(toAdd);
    }
    public void removeAllSolvedClues(){
        this.myClues.clear();
    }
}
