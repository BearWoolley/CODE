import java.io.*;
/**
 * Enumeration class ChampionState 
 * 
 * @author A.Marczyk
 * @version (version number or date here)
 */
public enum ChampionState implements Serializable
{
    FORHIRE(" For hire"), ACTIVE(" Active"),RESTING(" Resting"),DEAD (" Dead");
    private String state;
    
    private ChampionState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
}
