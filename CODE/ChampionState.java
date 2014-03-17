 

 

import java.io.*;
/**
 * Enumeration class ChampionState - This class helps to show the state of a champion.
 **/
public enum ChampionState implements Serializable
{
    FORHIRE(" For hire"), ACTIVE(" Active"),RESTING(" Resting"),DEAD (" Dead");
    private String state;
    
    /** Constructor requires the state of the champion
     * @param st is the state of the champion
     */ 
    private ChampionState(String st)
    {
        state = st;
    }
    
    /**Returns the state of the champion 
     * @return is the state of the champion 
     **/
    public String toString()
    {
        return state;
    }
}
