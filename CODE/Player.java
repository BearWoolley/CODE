
//import CODE.Champion;
//import CODE.ChampionState;
//import CODE.Game;
//import CODE.Warrior;
//import CODE.Wizard;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;
/**
 * This class implements the behaviour expected from the CODE
 * @author Name: Joshua Woolley Student ID: 14088338    Name: Naveed Javed  Student ID: 14091157
 */

public class Player implements Game, Serializable
{
    private String name;
    private int treasury;
    private HashMap<Champion, ChampionState> champions = new HashMap<Champion, ChampionState>();
    private HashMap<Challenge, ChallengeType> challenges = new HashMap<Challenge,ChallengeType>();
    private ArrayList<Champion> army = new ArrayList<Champion>();

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
        //readChallenges();
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
        if(army.size() > 0){
            s = s + toArmyString();
        }
        else{
            s =s + "\nNo champions \n";
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
        if(treasury <= 0 && army.size() < 1){
            return true;
        }
        else
        {
            return false;
        }
    }

    // ***************** Army of Champions ************************  

    /**Returns a String representation of all champions available for hire
     * @return a String representation of all champions available for hire
     **/
    public String getAllChampionsForHire()
    {   
        String details = "";
        for(Map.Entry<Champion, ChampionState> entry : champions.entrySet()){
            ChampionState state = entry.getValue();
            if(state.equals(ChampionState.FORHIRE)){
                details = details + entry.getKey().toString() + "\n";
            }
        }
        return details;
    }

    /** Returns details of a champion with the given name
     * @return details of a champion with the given name
     **/
    public String getChampion(String name)
    {   
        String details = "";
        for(Map.Entry<Champion, ChampionState> entry : champions.entrySet()){
            if(entry.getKey().getName().equals(name)){
                ChampionState state = entry.getValue();
                details = "State: " + state.toString() + entry.getKey().toString();
            }
        }
        if(details.equals("")){ details = "Champion not found"; }
        return details;
    }

    // ***************** Army Champions ************************   
    /** Allows a champion to be hired for the army, if there 
     * is enough money in the treasury for their hire fee.The champion's 
     * state is set to "active"
     * @param name is the name of the champion
     * @return name and either "- not found" if champion not found,or "- cannot 
     * be hired" if champion is not for hire,already hired/dead, "- hired and 
     * available" if champion hired, "- not enough money" if not enough money
     * in the treasury
     **/        
    public String hireChampion(String name) {
        Champion champ = getChamp(name);
        if (champ != null) {
            if (treasury >= champ.getHireFee()) {
                if (champions.get(champ).equals(ChampionState.FORHIRE)) {
                    champions.put(champ, ChampionState.ACTIVE);
                    army.add(champ);
                    treasury = treasury - champ.getHireFee();
                    return "Hired and available";
                } else {
                    return "Cannot be hired because they are either hired, dead or resting";
                }
            } else {
                return "Not enough money";
            }
        } else {
            return "Champion not found";
        }
    }

    /**Returns a String representation of the champions in the player's army
     * with an appropriate header, or the message "No champions hired"
     * @return a String representation of the champions in the player's army
     **/
    public String getArmy()
    {   
        if(!army.isEmpty())
        {
            int index = 0;
            String details = "";
            while(index < army.size()){
                Champion c = army.get(index);
                details = details + "\n\n" + c.toString();
                index++;
            }
            return details;
        }
        else
        {
            return "No champions hired";
        }
    }

    /** Returns true if the champion with the name is in the player's army, 
     * false otherwise.
     * @param name is the name of the champion
     * @return true if the champion with the name is in the player's army, 
     * false otherwise.
     **/
    public boolean isInArmy(String name)
    {   
        int index = 0;
        boolean inArmy = false;
        while(index < army.size()){
            Champion champ = army.get(index);
            if(champ.getName().equals(name)){
                inArmy = true;
            }
            index++;
        }
        return inArmy;
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
        boolean dismiss = false;
        if(isInArmy(name)){
            Champion champ = getChamp(name);
            if(champions.get(champ) == ChampionState.ACTIVE || champions.get(champ) == ChampionState.RESTING && champ != null){
                champions.put(champ, ChampionState.FORHIRE);
                army.remove(champ);
                treasury = treasury + (champ.getHireFee() / 2);
                dismiss = true;
            }
        }
        return dismiss;
    }

    /**Restores a champion to the army by setting their state to ACTIVE 
     * @param the name of the champion to be restored
     * @return true if restored, else false
     */
    public boolean restoreChampion(String name)
    {       
        Champion champ = getChamp(name);
        if(champions.get(champ) == ChampionState.RESTING && champ != null){
            if (treasury >= 50) {
                champions.put(champ, ChampionState.ACTIVE);
                treasury = treasury - 50;
                return true;
            }
            else{ return false; }
        }
        else{ return false; }
    }
    //**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the reference number of the challenge
     * @returns true if the reference number represents a challenge
     **/
    public boolean isChallenge(int num)
    {
        Challenge chall = getChall(num);
        if(chall != null){

            return true;
        }
        else{ return false; }
    }

    /** Meets the challenge represented by the challenge number (or returns 
     * " - no such challenge").Find a champion from the army who can meet the 
     * challenge and return a result which is one of the following: �Challenge 
     * won by...� � add reward to treasury, set the champion to resting and add 
     * the name of champion, �Challenge lost as no champion available� � deduct 
     * reward from treasury,�Challenge lost on skill level�- deduct reward from 
     * treasury, the champion is killed, so add "<champion name> is dead" to the 
     * return String. If the challenge is lost and there is no money left, add 
     * "You have NO money in the treasury".
     * @param challNo is the reference number of the challenge
     * @return a String showing the result of meeting the challenge
     */
    public String meetChallenge(int challNo) {
        String details = "";
        if (isChallenge(challNo)) {
            Challenge chall = getChall(challNo);
            if (challenges.get(chall) == ChallengeType.MAGIC) {
                int index = 0;
                if(army.size() == 0){ return "No Champions hired"; }
                while(index < army.size()){
                    Champion champion = army.get(index);
                    if(champions.get(champion) == ChampionState.ACTIVE){
                        if (champion instanceof Wizard) {
                            if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                return challengeWon(champion, chall);
                            } else {
                                treasury = treasury - chall.getRewardMoney();
                                champions.put(champion, ChampionState.DEAD);
                                army.remove(champion);
                                return "Challenge was lost. \n" + champion.getName() + " is dead.";
                            }
                        }
                        else{ details = "Champion cannot fight this type"; }
                    }
                    else{ details = "Champion needs to be Active"; }
                    index++;
                }
                return details;
            } else if (challenges.get(chall) == ChallengeType.FIGHT) {
                int index = 0;
                if(army.size() == 0){ return "No Champions hired"; }
                while(index < army.size()) {
                    Champion champion = army.get(index);
                    if(champions.get(champion) == ChampionState.ACTIVE){
                        if (champion instanceof Warrior) {
                            if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                return challengeWon(champion, chall);
                            } else {
                                return challengeLost(champion, chall);
                            }
                        } else if (champion instanceof Dragon) {
                            if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                return challengeWon(champion, chall);
                            } else {
                                return challengeLost(champion, chall);
                            }
                        }
                        else if(champion instanceof Gryphon){
                            if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                return challengeWon(champion, chall);
                            } else {
                                return challengeLost(champion, chall);
                            }
                        }
                        else{ details = "Champion cannot fight this type"; }
                    }
                    else{ details = "Champion needs to be Active"; }
                    index++;
                }
                return details;
            } else if (challenges.get(chall) == ChallengeType.MYSTERY) {
                int index = 0;
                if(army.size() == 0){ return "No Champions hired"; }
                while(index < army.size()) {
                    Champion champion = army.get(index);
                    if(champions.get(champion) == ChampionState.ACTIVE){
                        if (champion instanceof Wizard) {
                            if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                return challengeWon(champion, chall);
                            } else {
                                return challengeLost(champion, chall);
                            }
                        } else if (champion instanceof Warrior) {
                            if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                return challengeWon(champion, chall);
                            } else {
                                return challengeLost(champion, chall);
                            }
                        } else if (champion instanceof Dragon) {
                            if (champion.canTalk()) {
                                if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                    return challengeWon(champion, chall);
                                } else {
                                    return challengeLost(champion, chall);
                                }
                            }
                        }
                        else if(champion instanceof Gryphon){
                            if (champion.getSkillLevel() >= chall.getSkillLevel()) {
                                return challengeWon(champion, chall);
                            } else {
                                return challengeLost(champion, chall);
                            }
                        }
                        else{ details = "Champion cannot fight this type"; }
                    }
                    else{ details = "Champion needs to be Active"; }
                    index++;
                }
                return details;
            }
            return "Error in doing challenge";
        } else {
            return "No such challenge";
        }
    }

    /** Provides a String representation of a challenge given by challenge number
     * pre-condition isChallenge(num)
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num)
    {   
        Challenge chall = getChall(num);
        return chall.toString();
    }

    /** Provides a String representation of all requests 
     * @return returns a String representation of of all requests
     **/
    public String getAllChallenges()
    {   
        String details = "";
        for(Map.Entry<Challenge, ChallengeType> entry : challenges.entrySet()){
            details = details + "\n" + entry.getKey().toString() + "\n";
        }
        return details;
    }

    //*********************** Task 1 ***********************************************
    /** Set up of all the champions and the states that are used in the game
     * 
     **/
    private void setupChampions()
    {   
        Champion champ1 = new Wizard("Ganfrank", 7, true, 400, "Transmutation");
        Champion champ2 = new Wizard("Rudolf", 6, true, 400, "Invisibility");
        Champion champ3 = new Warrior("Elblond", 200, "Sword");
        Champion champ4 = new Warrior("Flimsi", 300, "Bow");
        Champion champ5 = new Dragon("Drabina",  false);
        Champion champ6 = new Dragon("Golum", true);
        Champion champ7 = new Warrior("Argon", 900, "Mace");
        Champion champ8 = new Wizard("Neon", 2, false, 300, "Translocation");
        champions.put(champ1, ChampionState.FORHIRE);
        champions.put(champ2, ChampionState.FORHIRE);
        champions.put(champ3, ChampionState.FORHIRE);
        champions.put(champ4, ChampionState.FORHIRE);
        champions.put(champ5, ChampionState.FORHIRE);
        champions.put(champ6, ChampionState.FORHIRE);
        champions.put(champ7, ChampionState.FORHIRE);
        champions.put(champ8, ChampionState.FORHIRE);
        
        Champion champ9 = new Gryphon("Grindle", 4, 200, "Bumbledore");
        champions.put(champ9, ChampionState.FORHIRE);
    }

    /** Set up of all the challenges and the type that are used in the game
     * 
     **/
    private void setupChallenges()
    {
        Challenge chall1 = new Challenge("Magic", "Borg", 3, 100);
        Challenge chall2 = new Challenge("Fight", "Huns", 3, 120);
        Challenge chall3 = new Challenge("Mystery", "Ferengi", 3, 150);
        Challenge chall4 = new Challenge("Magic", "Vandals", 9, 200);
        Challenge chall5 = new Challenge("Mystery", "Borg", 7, 90);
        Challenge chall6 = new Challenge("Fight", "Goths", 8, 45);
        Challenge chall7 = new Challenge("Magic", "Franks", 10, 200);
        Challenge chall8 = new Challenge("Fight", "Sith", 10, 150);
        challenges.put(chall1, ChallengeType.MAGIC);
        challenges.put(chall2, ChallengeType.FIGHT);
        challenges.put(chall3, ChallengeType.MYSTERY);
        challenges.put(chall4, ChallengeType.MAGIC);
        challenges.put(chall5, ChallengeType.MYSTERY);
        challenges.put(chall6, ChallengeType.FIGHT);
        challenges.put(chall7, ChallengeType.MAGIC);
        challenges.put(chall8, ChallengeType.FIGHT);
        
        Challenge chall9 = new Challenge("Fight", "Romulans", 2, 225);
        challenges.put(chall9, ChallengeType.FIGHT);
    }

    //*******************************************************************************

    /************************ Task 5 ************************************************/
    /** reads data about champions from a text file and stores in collection of 
     * champions.Data in the file is  "comma separated" and so editable
     * @param fileName name of the file to be read
     */   
    private void readChampions(String fileName) {
        File f = new File(fileName);
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(f));
            String champ = myReader.readLine();
            while (champ != null) {
                String[] parts = champ.split(",");
                if (parts[0].equals("wizard")) {
                    int money = 300;
                    boolean necro = Boolean.parseBoolean(parts[3]);
                    if (necro) {
                        money = 400;
                    }
                    Champion c1 = new Wizard(parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), money, parts[4]);
                    champions.put(c1, ChampionState.FORHIRE);
                } else if (parts[0].equals("warrior")) {
                    Champion c1 = new Warrior(parts[1], Integer.parseInt(parts[2]), parts[3]);
                    champions.put(c1, ChampionState.FORHIRE);
                } else if (parts[0].equals("dragon")) {
                    Champion c1 = new Dragon(parts[1], Boolean.parseBoolean(parts[2]));
                    champions.put(c1, ChampionState.FORHIRE);
                } else if(parts[0].equals("gryphon")) {
                    Champion c1 = new Gryphon(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
                    champions.put(c1, ChampionState.FORHIRE);
                }
                champ = myReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //************************ Task 6 **********************************
    /** reads data about challenges from an object file and stores in collection of 
     * champions.Data in the file is not editable
     * @param fileName name of the file to be read
     */
    private void readChallenges()
    { 
        Challenge c;
        try{
            FileInputStream fis = new FileInputStream ("challenges.txt");
            ObjectInputStream ois = new ObjectInputStream (fis);
            while(ois != null){
                c = (Challenge) ois.readObject();
                System.out.println(c);
                challenges.put(c, c.getType());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ********************   Task 6 object write/read  *********************
    /**
     * Saves the state of the game to the file with the given name 
     * @param fname the name of the file 
     */ 
    public void saveGame(String fname)
    {   // uses object serialisation
        try{
            FileOutputStream file = new FileOutputStream(fname + ".txt", true);
            ObjectOutputStream inf  = new ObjectOutputStream (file);
            inf.writeObject(this);
            inf.close();
        }
        catch(IOException e){
             System.out.println(e);
        }
    }

    /** 
     * Restores the game from the file with the given name
     * @param fname the name of the file 
     */
    public Game restoreGame(String fname)
    {   
        Player g = null;
        // uses object serialisation 
        try{
            FileInputStream fis = new FileInputStream (fname + ".txt");
            ObjectInputStream ois = new ObjectInputStream (fis);
            g = (Player) ois.readObject();
            ois.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return g;
    } 
    /**
     * Returns string about wining challenge
     * @param champ Champion that is doing the challenge
     * @param chall Challenge that is doing the challenge
     * @return String of the champion wining and their name
     */
    private String challengeWon(Champion champ, Challenge chall){
        treasury = treasury + chall.getRewardMoney();
        champions.put(champ, ChampionState.RESTING);
        return "Challenge won by " + champ.getName();
    }
    
    /**
     * Returns string about losing challenge
     * @param champ Champion that is doing the challenge
     * @param chall Challenge that is doing the challenge
     * @return String of the champion losing and their name
     */
    private String challengeLost(Champion champ, Challenge chall){
        treasury = treasury - chall.getRewardMoney();
        champions.put(champ, ChampionState.DEAD);
        army.remove(champ);
        return "Challenge was lost. \n" + champ.getName() + " is dead.";
    }
    
    /** 
     * Returns the champion in the army in a string format
     * @returns the army in a string format 
     */
    private String toArmyString(){
        int index = 0;
        String details = "";
        while(index < army.size()){
            Champion champ = army.get(index);
            details = details + "\n" + champ.toString();
            index++;
        }
        return details;
    }
    
    /** 
     * Returns the specified champion
     * @param name the details of the champion
     * @returns the details of the specified champion
     */
    private Champion getChamp(String name){
        Champion champ = null;
        for(Map.Entry<Champion, ChampionState> entry : champions.entrySet()){
            if(entry.getKey().getName().equals(name)){
                champ = entry.getKey();
            }
        }
        return champ;
    }

    /** 
     * Returns the specified challenge
     * @param nukber the number of the challenge
     * @returns the details of specified challenge
     */
    private Challenge getChall(int number){
        Challenge chall = null;
        for(Map.Entry<Challenge, ChallengeType> entry : challenges.entrySet()){
            if(entry.getKey().getChallengeNumber() == number){
                chall = entry.getKey();
            }
        }
        return chall;
    }
}