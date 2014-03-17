import java.io.*; 

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 *  Wizard class is the child class to the champion class contianing information
 * about the wizard champions
 * 
 */
public class Wizard extends Champion implements Serializable{
    
    private boolean necromancer;
    private String spell;
    
    /** Constructor requires the name, skill level, necromancer, cost, and spll. Super used from Champion class
     * @param name is the name of the champion, skillLevel is the eel of skill, cost is the cost of champion,
     * spellSpec is the spell specified to wiazrd
     */
    public Wizard(String name, int skillLevel, boolean necro, int cost, String spellSpec){
        super(name, skillLevel, cost);
        necromancer = necro;
        spell = spellSpec;
    }
    
    /**Returns if Necormancer
     * @return bollean value if necromancer or not
     **/ 
    public boolean getNecromancer(){
        return necromancer;
    }
    
    /**Returns the spell specified
     * @return the spell that is specified
     **/
    public String getSpell(){
        return spell;
    }
    
    /**Returns true or false if champion can talk
     * @return the bollean value true or false
     **/ 
    public boolean canTalk(){
        return true;
    }
    
    /**Returns the information of the class, Super and if they can talk
     * @return a to string to show information about the class 
     **/
    public String toString(){
        return "\nWizard \n" + super.toString() + "\nNecromancer: " + necromancer + "\nSpell Speciality: " + spell;
    }
    
}
