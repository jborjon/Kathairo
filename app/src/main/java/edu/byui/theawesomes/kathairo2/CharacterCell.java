package edu.byui.theawesomes.kathairo2;

/**
 * Created by fmcho on 6/29/2016.
 */
public class CharacterCell {

    /**
     * this is the variable that hold the string the user sees
     */
    private String character;

    /*****************************************************
     * this is to keep track of where the index is
     ******************************************************/
    private int index;

    /****************************************************
     *
     * @param
     * @return
     *****************************************************/
    public void setCharacter(String toSet){
        this.character = toSet;
    }

    /****************************************************
     *
     *
     *****************************************************/
    public void setIndex(int toSet){
        this.index = toSet;
    }

    /****************************************************
     *
     *
     *****************************************************/
    public String getCharacter(){
        return this.character;
    }

    /****************************************************
     *
     *
     *****************************************************/
    public  int getIndex(){
        return this.index;
    }

}