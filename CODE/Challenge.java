import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 * Challenge class controls the challanges, the number, and everything related to the challenge
 * 
 */
public class Challenge implements Serializable{
    
    private static int challengerNum = 1;
    private int number;
    private String enemy;
    private int skill;
    private int reward;
    private ChallengeType type;
    
    /** Constructor requires the type of challenge, the skill, name, and fee
     * @param challType is the challenge type, name of the enemy, skill is the skill level, money is the reward
     */ 
    public Challenge(String challType, String name, int skillLevel, int money){
        setType(challType);
        enemy = name;
        skill = skillLevel;
        reward = money;
        number = challengerNum;
        challengerNum++;
    }
    
    /**Returns the name of the enemy 
     * @return is the name of the enemy
     **/ 
    public String getName(){
        return enemy;
    }
    
    /**Returns the number of the challenge
     * @return is the number of the challenge
     **/ 
    public int getChallengeNumber(){
        return number;
    }
    
    /**Returns the skill level
     * @return the skill level
     **/ 
    public int getSkillLevel(){
        return skill;
    }
    
    /**Returns the amount of reward for challenge
     * @return is the amount in money for winning challenge
     **/ 
    public int getRewardMoney(){
        return reward;
    }
    
    /**Returns the type of the challenge
     * @return the type for the challenge
     **/
    public ChallengeType getType(){
        return type;
    }
    
    /**Returns the information of the number, name, enemy, skill, and reward
     * @return a to string to show information about the class 
     **/ 
    public String toString(){
        return "Challenge Number: " + number + "\nName: " + enemy + "\nSkill Level: " + skill + "\nReward Money: " + reward;
    }
    
    /** reads data and converts it from a upper case to a lowercase
     * @param challType type of the challenge to turned into lower case
     **/
    private void setType(String challType){
        if(challType.toLowerCase().equals("magic")){
            type = ChallengeType.MAGIC;
        }
        else if(challType.toLowerCase().equals("fight")){
            type = ChallengeType.FIGHT;
        }
        else if(challType.toLowerCase().equals("mystery")){
            type = ChallengeType.MYSTERY;
        }
    }
}
