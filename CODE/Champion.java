import java.io.*;
/** 
 * Champion class is the inheritace class to the warrior, wizad and dragon class, contianing information
 * about the champions
 */
public abstract class Champion implements Serializable{
    
    private String name;
    private int skillLevel;
    private int hireFee;
    
    /** Constructor requires the name of the champion, the skill, and fee
     * @param nam is the name of the champion, skill is the skill, fee is the cost
     */
    public Champion(String nam, int skill, int fee){
        name = nam;
        skillLevel = skill;
        hireFee = fee;
    }
    
    /**Returns the name of the champion 
     * @return is the name of the champion 
     **/
    public String getName(){
        return name;
    }
    
    /**Returns the skill level
     * @return the skill level
     **/ 
    public int getSkillLevel(){
        return skillLevel;
    }
    
    /**Returns the cost known as the hirefee
     * @return is the hirefee  
     **/
    public int getHireFee(){
        return hireFee;
    }
    
    /**Returns if champion can talk
     * @return true or false if champion can talk or not 
     **/
    public abstract boolean canTalk();
    
    /**Returns the information of the class, name, skill, and fee
     * @return a to string to show information about the class 
     **/
    public String toString(){
        return "Name: " + name + "\nSkill Level: " + skillLevel + "\nHire Fee: " + hireFee;
    }
}
