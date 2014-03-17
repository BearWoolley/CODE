import java.io.*; 

 


//import CODE.Champion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 * Dragon class is the child class to the champion class contianing information
 * about the dragon champions
 */
public class Dragon extends Champion implements Serializable{
    
    private boolean talk;
    
    /** Constructor requires the name, and if the dragon talks. Super used from Champion class
     * @param name is the name of the champion, talks is if they can talk or not
     */ 
    public Dragon(String name, boolean talks){
        super(name, 7, 500);
        talk = talks;
    }
    
    /**Returns true or false if champion can talk
     * @return the bollean value true or false
     **/
    public boolean canTalk(){
        return talk;
    }
    
    /**Returns the information of the class, Super and if they can talk
     * @return a to string to show information about the class 
     **/ 
    public String toString(){
        return "\nDragon \n" + super.toString() + "\nTalks: " + talk;
    }
}
