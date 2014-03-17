import java.io.*; 

 


//import CODE.Champion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 * Warrior class is the child class to the champion class contianing information
 * about the warrior champions 
 */
public class Warrior extends Champion implements Serializable{
    
    private String weapon;
    
    /** Constructor requires the name, and the weapon specified. Super used from Champion class
     * @param name is the name of the champion, fee is the cost of champion,
     * weap is the weapon specified to warrior
     */ 
    public Warrior(String name, int fee, String weap){
        super(name, (fee / 100), fee);
        weapon = weap;
    }
    
    /**Returns the weapon specified
     * @return the weapon that is specified
     **/ 
    public String getWeapon(){
        return weapon;
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
        return "\nWarrior \n" + super.toString() + "\nWeapon: " + weapon;
    }
    
}
