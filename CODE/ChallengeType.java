 

 

import java.io.*;
/**
 * Enumeration class ChallengeType - This class helps to show the type of a challange, also 
 * helping to create a new challange
 **/
public enum ChallengeType implements Serializable
{
    MAGIC("Magic"), FIGHT("Fight"), MYSTERY ("Mystery");
    private String type;
    
    /** Constructor requires the type of the challange
     * @param ty is the type of the challenge
     **/
    private ChallengeType(String ty)
    {
        type = ty;
    }
    
    /**Returns the type of the champion 
     * @return is the type of the champion 
     **/ 
    public String toString()
    {
        return type;
    }
}