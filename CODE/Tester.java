
/**
 * Tester class to help test methods in other classes and to show if any bugs are present
 * 
 */
public class Tester
{
    private Game haratio = new Player ("Haratio");  //new player called haratio
    
    public void doTest()
    {
        
        System.out.println(haratio.hireChampion("Neon"));   //hire a champion that exsists
        System.out.println();
        System.out.println(haratio.hireChampion("Ganfrank"));   //hire a champion that exists
        System.out.println();
        System.out.println(haratio.hireChampion("Argon"));  //hire a champion that exists
        System.out.println();
        System.out.println(haratio.hireChampion("Frank"));  //hire a champion that doesn't exist
        System.out.println();
        System.out.println(haratio.hireChampion("Neon"));   //hire a champion that already is in army
        
        System.out.println(haratio.getArmy());  //get champions in the army
        
        System.out.println();
        
        System.out.println(haratio.isInArmy("Neon"));   //check if in army
        System.out.println();
        System.out.println(haratio.isInArmy("Ganfrank"));   //check if in army
        System.out.println();
        System.out.println(haratio.isInArmy("Argon"));  //check if in army
        System.out.println();
        System.out.println(haratio.isInArmy("Frank"));  //check if in army
            
        System.out.println(haratio.getAllChallenges()); //get all challanges
        
        System.out.println(haratio.getAllChampionsForHire());   //get all champions
        
        System.out.println();
        
        System.out.println(haratio.meetChallenge(1));   //meet challenge number 1
        System.out.println();
        System.out.println(haratio.getMoney()); //check the state of treasury
        System.out.println();
        System.out.println(haratio.hasLost());  //check to see if the player has lost
        System.out.println();
        System.out.println(haratio.getArmy());  //get champions in the army
        System.out.println();
        System.out.println(haratio.restoreChampion("Neon"));    //Check to see if the champion can be restored
        System.out.println();
        System.out.println(haratio.restoreChampion("Argon"));   //Check to see if the champion can be restored
        System.out.println();
        
        System.out.println(haratio.dismissChampion("Argon"));   //dismiss a champion
        System.out.println();
        System.out.println(haratio.getMoney()); //check the state of treasury
        
        System.out.println();
        
        System.out.println(haratio.hireChampion("Drabina"));    //hire a champion that exists
        System.out.println();
        System.out.println(haratio.isInArmy("Drabina"));    //check if in army
        System.out.println();
        System.out.println(haratio.getMoney()); //check the state of treasury
        System.out.println();
        System.out.println(haratio.meetChallenge(2));   //meet challenge number 2
        System.out.println();
        System.out.println(haratio.getMoney()); //check the state of treasury
        
        System.out.println();
        System.out.println(haratio.restoreChampion("Drabina")); //restore champion who is resting
        System.out.println();
        
        System.out.println(haratio.isInArmy("Granfrank"));  //check if in army
        System.out.println();
        System.out.println(haratio.meetChallenge(8));   //meet challenge number 8
        System.out.println();
        System.out.println(haratio.restoreChampion("Granfrank"));   //restore champion 
        System.out.println();
        
        System.out.println(haratio.dismissChampion("Drabina")); //dismiss a champion
        System.out.println();
        
        System.out.println(haratio.getChampion("Ganfrank"));    //get a specific champion
        System.out.println();
        
        System.out.println(haratio.dismissChampion("Ganfrank"));    //dismiss a champion
    }
}
