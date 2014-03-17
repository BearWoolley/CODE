import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * GameGUI class, class to create the graphical user interface for the game, holds data 
 * such as the size, the font, the type and other GUI related information .
 * @author Name: Joshua Woolley Student ID: 14088338    Name: Naveed Javed  Student ID: 14091157
 */
public class GameGUI
{
    Player CODE = new Player("Hero");
    private JFrame myFrame = new JFrame("Champions of Disc Earth");
    private JTextArea listing = new JTextArea();
    private JButton meetButton = new JButton("Meet Challenge");
    private JButton viewButton = new JButton("View State");
    private JButton clearButton = new JButton("Clear");
    private JButton quitButton = new JButton("Quit");
    private JPanel westPanel = new JPanel();
    
    /**
     * Constructor for the GameGUI class, does not have any parameters
     * 
     */
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    
    /**
     * Method to make the frame, the content pane and the layout
     */
    private void makeFrame(){
        Container contentPane = myFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        contentPane.add(westPanel, BorderLayout.WEST);
        westPanel.setLayout(new GridLayout(4,1));
        westPanel.add(meetButton);
        westPanel.add(viewButton);
        westPanel.add(clearButton);
        westPanel.add(quitButton);
        meetButton.setVisible(true);
        viewButton.setVisible(true);
        clearButton.setVisible(false);
        quitButton.setVisible(true);
        
        clearButton.addActionListener(new ClearButtonHandler());
        viewButton.addActionListener(new ViewButtonHandler());
        quitButton.addActionListener(new QuitButtonHandler());
        meetButton.addActionListener(new MeetButtonHandler());
        
        contentPane.add(listing,BorderLayout.CENTER); 
        listing.setVisible(false);        
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Method to make the frame, the menu bare and everything that will go into the menu bar
     */
    private void makeMenuBar(JFrame frame){
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu champions = new JMenu("Champions");
        menubar.add(champions);
        
        JMenuItem listChampions = new JMenuItem("List all champions");
        listChampions.addActionListener(new ListAllHandler());
        champions.add(listChampions);
        
        JMenuItem listArmy = new JMenuItem("List my army");
        listArmy.addActionListener(new ListArmyHandler());
        champions.add(listArmy);
        
        JMenuItem hireChampion = new JMenuItem("Hire a Champion");
        hireChampion.addActionListener(new HireChampionHandler());
        champions.add(hireChampion);
        
        JMenuItem dismissChampion = new JMenuItem("Dismiss a Champion");
        dismissChampion.addActionListener(new DismissChampionHandler());
        champions.add(dismissChampion);
        
        JMenuItem restoreChampion = new JMenuItem("Restore a Champion");
        restoreChampion.addActionListener(new RestoreChampionHandler());
        champions.add(restoreChampion);
        
        JMenuItem viewChampion = new JMenuItem("View a Champion");
        viewChampion.addActionListener(new ViewChampionHandler());
        champions.add(viewChampion);
        
        JMenuItem showMoney = new JMenuItem("Show Money");
        showMoney.addActionListener(new ShowMoneyHandler());
        champions.add(showMoney);
    }
    
    /**
     * Method to list all the champions for hire
     */
    private class ListAllHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            clearButton.setVisible(true);
            String s = CODE.getAllChampionsForHire();
            listing.setText(s);
            listing.setVisible(true);
        }
    }
    
    /**
     * Method to clear everything off the frame
     */
    private class ClearButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {            
            listing.setVisible(false);
            clearButton.setVisible(false);
        }
    }
    
    /**
     * Method to view the state of the treasury
     */
    private class ViewButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {      
            clearButton.setVisible(true);
            String s = CODE.toString();
            listing.setText(s);
            listing.setVisible(true);
        }
    }
    
    /**
     * Method to allow the player to exit the system
     */
    private class QuitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {      
            System.exit(1);
        }
    }
    
    /**
     * Method to allow the player to meet a challenge
     */
    private class MeetButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {      
            String chall = JOptionPane.showInputDialog("Enter the number of the Challenge you wish to fight: ");
            int challNum = Integer.parseInt(chall);
            String result = CODE.meetChallenge(challNum);
            JOptionPane.showMessageDialog(myFrame,result);
        }
    }
    
    /**
     * Method to allow the player to list his army
     */
    private class ListArmyHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            clearButton.setVisible(true);
            String s = CODE.getArmy();
            listing.setText(s);
            listing.setVisible(true);
        }
    }
    
    /**
     * Method to allow the player to hire a champion
     */
    private class HireChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String championName = JOptionPane.showInputDialog("Name of Champion you wish to hire: ");
            String result = CODE.hireChampion(championName);
            JOptionPane.showMessageDialog(myFrame,result);
        }
    }
    
    /**
     * Method to allow the player to dismiss a champion
     */
    private class DismissChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "Failed to dismiss champion";
            String championName = JOptionPane.showInputDialog("Name of Champion you wish to dismiss: ");
            boolean dismiss = CODE.dismissChampion(championName);
            if(dismiss){
                result = "Champion has been dismissed";
            }
            JOptionPane.showMessageDialog(myFrame,result);
        }
    }
    
    /**
     * Method to allow the player to restore a champion
     */
    private class RestoreChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "Failed to restore champion";
            String championName = JOptionPane.showInputDialog("Name of Champion to be restored: ");
            boolean dismiss = CODE.restoreChampion(championName);
            if(dismiss){
                result = "Champion has been restored and is now able to fight";
            }
            JOptionPane.showMessageDialog(myFrame,result);
        }
    }
    
    /**
     * Method to allow the player to view champion
     */
    private class ViewChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String championName = JOptionPane.showInputDialog("Name of Champion you wish to view: ");
            String s = CODE.getChampion(championName);
            listing.setText(s);
            clearButton.setVisible(true);
            listing.setVisible(true);
        }
    }
    
    private class ShowMoneyHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            clearButton.setVisible(true);
            String s = "Treasury: " + CODE.getMoney();
            listing.setText(s);
            listing.setVisible(true);
        }
    }
}
