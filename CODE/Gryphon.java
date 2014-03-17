import java.io.*; 
/**
 * Warrior class is the child class to the champion class contianing information
 * about the warrior champions 
 */
public class Gryphon extends Champion implements Serializable{
    
    private String handler;
    
    /** Constructor requires the name, and the weapon specified. Super used from Champion class
     * @param name is the name of the champion, fee is the cost of champion,
     * hand is the handler for the Gryphon
     */ 
    public Gryphon(String name, int skill, int fee, String hand){
        super(name, skill, fee);
        handler = hand;
    }
    
    /**Returns the handler
     * @return the handler
     **/ 
    public String getHandler(){
        return handler;
    }
    
    /**Returns true or false if champion can talk
     * @return the boolean value true or false
     **/
    public boolean canTalk(){
        return true;
    }
    
    /**Returns the information of the class, Super and if they can talk
     * @return a to string to show information about the class 
     **/ 
    public String toString(){
        return "\nGryphon \n" + super.toString() + "\nHandler: " + handler;
    }
    
}

