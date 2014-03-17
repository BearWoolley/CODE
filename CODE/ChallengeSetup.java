import java.util.*;
import java.io.*;
/**
 * ChallengeSetup class helps to create a new challenge that can be added to the game
 * 
 */
public class ChallengeSetup implements Serializable
{
    /** reads data from terminal window and allows the player to create a challenge with
     * the help of commands.
     */
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        String challenge = "";
        while(true){
            System.out.println("Please enter the following information in: (If you wish to quit enter quit now)");
            try{
                FileOutputStream file = new FileOutputStream("challenges.txt", true);
                ObjectOutputStream inf  = new ObjectOutputStream (file);
                System.out.println("Enter which type of Challenge you want to make: (Magic, Fight, Mystery)");
                String type = reader.next();
                if(type.equals("quit")){ System.exit(1); }
                System.out.println("Enter the name of the challenge:");
                String challName = reader.next();
                System.out.println("Enter the skill level of the challenge:");
                int skill = reader.nextInt();
                System.out.println("Enter the reward money of the challenge:");
                int money = reader.nextInt();
                Challenge c1 = new Challenge(type, challName, skill, money);
                inf.writeObject(c1);
                inf.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
    }
}

