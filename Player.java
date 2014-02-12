import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the CODE
 * system as required for 5COM0087 Cwk 3 - Feb 2014
 * 
 * @author A.A.Marczyk 
 * @version 02/02/14
 */

public class Player implements Game
{
    private String name;
    private int treasury;

//**************** DiscEarth ************************** 
    /** Constructor requires the name of the player
     * @param player is the name of the player
     */  
    public Player(String player)
    {
       name = player;
       treasury = 1000;
       setupChampions();
       setupChallenges();
    }
    
    /** Constructor requires the name of the player and the
     * name of the file storing champions
     * @param player is the name of the player
     * @param filename name of file storing champions
     */  
    public Player(String player, String filename)
    {
       name = player;
       treasury = 1000;       
       readChampions(filename); // read from text file
       //comment for testing Task 5 
       setupChallenges();
       // uncomment for testing Task 5
//        readChallenges();
    }
    
    /**Returns the name of the player 
     * @return is the name of the player 
     **/ 
    public String getName()
    {
        return name;
    }
    
    /**Returns a String representation of the state of the game,
     * including the name of the player, state of the treasury,whether 
     * player has lost or is still OK, and the champions in the army 
     * (or, "No champions" if army is empty)
     * @return a String representation of the state of the game,
     * including the name of the player, state of the treasury, whether 
     * player has lost or is still OK, and the champions in the army 
     * (or, "No champions" if army is empty)
     **/
    public String toString()
    {
        String s = "\nPlayer: " + name ;
        s = s + "\nTreasury: " + treasury;        
        if (hasLost())
        {
            s = s + "\nYou have lost \n" ;
        }
        else
        {
            s = s + "\nYou are still OK \n" ;
        }
        // add the army to this String, or "no Champions in the army"
        return s;
    }
    
    
    /** returns the amount of money in the treasury
     * @returns the amount of money in the treasury
     */
    public int getMoney()
    {
        return treasury;
    }

    /** returns true if treasury <=0 and the army has no champions 
     * who can be dismissed. 
     * @returns true if treasury <=0 and the army has no champions 
     * who can be dismissed. 
     */
    public boolean hasLost()
    {
        return false;
    }

    // ***************** Army of Champions ************************  
    
    /**Returns a String representation of all champions available for hire
     * @return a String representation of all champions available for hire
     **/
    public String getAllChampionsForHire()
    {   
        return null;
    }
    
    /** Returns details of a champion with the given name
     * @return details of a champion with the given name
     **/
    public String getChampion(String name)
    {   
        return null;
    }
    

 // ***************** Army Champions ************************   
    /** Allows a champion to be hired for the army, if there 
     * is enough money in the treasury for their hire fee.The champion's 
     * state is set to "active"
     * @param name is the name of the champion
     * @return name and either "- not found" if champion not found,or "- cannot 
     * be hired" if champion is not for hire,already hired/dead, "- hired and 
     * avialable" if champion hired, "- not enough money" if not enough money
     * in the treasury
     **/        
    public String hireChampion(String name)
    {   
        return null;
    }
        
    /**Returns a String representation of the champions in the player's army
     * with an appropriate header, or the message "No champions hired"
     * @return a String representation of the champions in the player's army
     **/
    public String getArmy()
    {   
        return null;
    }
    
   /** Returns true if the champion with the name is in the player's army, 
     * false otherwise.
     * @param name is the name of the champion
     * @return true if the champion with the name is in the player's army, 
     * false otherwise.
     **/
    public boolean isInArmy(String name)
    {   
        return false;
    }
    
    /** Dismisses a champion from the army and add half of their hire fee 
     * to the treasury.Champion must be active or resting.Champion should
     * now be for hire.
     * pre-condition: isInArmy(name)and is not dead
     * @param name is the name of the champion
     * @return true if dismissed, else false
     **/
    public boolean dismissChampion(String name)
    {       
        return false;
    }
   
    
    /**Restores a champion to the army by setting their state to ACTIVE 
     * @param the name of the champion to be restored
     * @return true if restored, else false
     */
    public boolean restoreChampion(String name)
    {       
        return false;
    }
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the reference number of the challenge
     * @returns true if the reference number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
         return false ;
     }
     
     
    /** Meets the challenge represented by the challenge number (or returns 
     * " - no such challenge").Find a champion from the army who can meet the 
     * challenge and return a result which is one of the following: “Challenge 
     * won by...“ – add reward to treasury, set the champion to restingand add 
     * the name of champion, “Challenge lost as no champion available” – deduct 
     * reward from treasury,“Challenge lost on skill level”- deduct reward from 
     * treasury, the champion is killed, so add "<champion name> is dead" to the 
     * return String. If the challenge is lost and there is no money left, add 
     * "You have NO money in the treasury".
     * @param challNo is the reference number of the challenge
     * @return a String showing the result of meeting the challenge
     */
    public String meetChallenge(int challNo)
    {   
        return null;
    }

    /** Provides a String representation of a challenge given by challenge number
     * pre-condition isChallenge(num)
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num)
    {   
        return null;
    }
    
    /** Provides a String representation of all requests 
     * @return returns a String representation of of all requests
     **/
    public String getAllChallenges()
    {   
        return null;
    }
    

    //*********************** Task 1 ***********************************************
   
    private void setupChampions()
    {   
        // depends on your collections

    }
    
    private void setupChallenges()
    {
       // depends on your collections
    }
    
    //*******************************************************************************
  
    /************************ Task 5 ************************************************/
    /** reads data about champions from a text file and stores in collection of 
     * champions.Data in the file is  "comma separated" and so editable
     * @param fileName name of the file to be read
     */   
    private void readChampions(String fileName)
    { 
        
    }   

    
    //************************ Task 6 **********************************
    /** reads data about challenges from an object file and stores in collection of 
     * champions.Data in the file is not editable
     * @param fileName name of the file to be read
     */
    private void readChallenges()
    { 
        
    }
    
    // ********************   Task 6 object write/read  *********************
    /**
     * Saves the state of the game to the file with the given name 
     * @param filename the name of the file 
     */ 
    public void saveGame(String fname)
    {   // uses object serialisation 
 
    }
    
    /** 
     * Restores the game from the file with the given name
     * @param filename the name of the file 
     */
    public Game restoreGame(String fname)
    {   // uses object serialisation         
        return null;
    } 
    
}


