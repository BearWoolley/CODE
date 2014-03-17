
/**
 * Write a description of class DemoC here.
 * 
 * @author Name: Joshua Woolley Student ID: 14088338    Name: Naveed Javed  Student ID: 14091157
 * @version (a version number or a date)
 */
public class DemoC
{
    public DemoC(){
        
    }
    
    public void doDemo(){
        Game gamer = new Player("Shelly");
        
        System.out.println(gamer.getAllChallenges() + "***************");
        
        System.out.println(gamer.hireChampion("Rudolf"));
        System.out.println(gamer.hireChampion("Elblond"));
        System.out.println(gamer.hireChampion("Golum"));    //Changed to Golum as I think Gollum is a spelling mistake
        System.out.println(gamer.hireChampion("Weakling"));
        System.out.println(gamer.toString());
        System.out.println(gamer.getAllChampionsForHire());
        
        System.out.println(gamer.meetChallenge(1));
        System.out.println();
        System.out.println(gamer.meetChallenge(2));
        System.out.println();
        System.out.println(gamer.meetChallenge(3));
        
        System.out.println();
        
        System.out.println(gamer.dismissChampion("Golum"));
        System.out.println(gamer.getArmy() + "***************");
        
        System.out.println();
        
        System.out.println(gamer.hireChampion("Argon"));
        System.out.println(gamer.hireChampion("Mary"));
        System.out.println(gamer.hireChampion("Grindle"));
        
        System.out.println(gamer.dismissChampion("Rudolf"));
        System.out.println();
        System.out.println(gamer.hireChampion("Grindle"));
        
        System.out.println();
        
        System.out.println(gamer.toString());
    }
}
