package edu.byui.theawesomes.kathairo2;
//random comment to get this commited and pushed!

/**
 * @author      Jordan Charles
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class CharacterCell {

    /**
     * this is the variable that holds the string the user sees
     */
    private String character;

    /*****************************************************
     * this is to keep track of where the index is
     ******************************************************/
    private int index;

    /****************************************************
     * Sets a character in the cell.
     *
     * @param toSet String The character to put in the cell
     *****************************************************/
    public void setCharacter(String toSet){
        this.character = toSet;
    }

    /****************************************************
     * Sets the index of the cell in the crossword puzzle.
     *
     * @param toSet int The index for the cell in the crossword puzzle
     *****************************************************/
    public void setIndex(int toSet){
        this.index = toSet;
    }

    /****************************************************
     * Returns the character contained in the cell.
     *
     * @return The character held by the cell
     *****************************************************/
    public String getCharacter(){
        return this.character;
    }

    /****************************************************
     * Returns the index of the cell in the crossword puzzle.
     *
     * @return The index of the cell in the crossword puzzle
     *****************************************************/
    public  int getIndex(){
        return this.index;
    }

}