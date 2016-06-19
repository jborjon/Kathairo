package edu.byui.theawesomes.kathairo2;

        import java.util.ArrayList;
        import java.util.Date;

/**
 * Created by fmcho on 6/18/2016.
 */
public class Clue {
    private int number, x, y;
    private String clue;
    private String answer , currentSolverName;
    private boolean isDown;
    private char[] userAswer;
    private ClueSolver clueSolver;
    private ArrayList <SolverLog> mySolverLog;

    public boolean checkSolved(){

        return true;r

    public void setUserAnswer(String answer){
        this.answer = answer;
    }
    public void updateSolvedLog(){

    }

    public char[] getUserAnswer(){
        return this.userAswer;
    }
    public void setIsDown(boolean isDown){
        this.isDown = isDown;
    }

    public boolean getIsDown(){
        return this.isDown;
    }

    public int getNumber(){
        return this.number;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Date getDateSolved(){
        Date userDate = new Date();
        return userDate;
    }

    public void addSolverLog(SolverLog toAdd){
        mySolverLog.add(toAdd);
    }

    public void setCurrentSolverName(String solverName){
        this.currentSolverName = solverName;
    }
    public boolean compareTo(String userimput){
        if(userimput == this.answer)
            return true;
            else return false;
    }
}

}
