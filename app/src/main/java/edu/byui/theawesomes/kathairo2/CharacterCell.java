package edu.byui.theawesomes.kathairo2;

/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
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