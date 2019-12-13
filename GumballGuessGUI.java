
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class GumballGuessGUI extends JPanel{
   //Windows Components
   private JFrame window = new JFrame("Gumball Guess");
   private JLabel lblName = new JLabel("Name: " ); 
   private JLabel lblGuess = new JLabel("Guess " );
   private JTextField txtName = new JTextField(""); 
   private JTextField txtGuess = new JTextField("");
   private JLabel lblStats = new JLabel("Winner");
   private JButton btnGuess = new JButton("Add Guess");
   private JButton btnCheckWinner = new JButton("Show Winner");
   
   ArrayList<guess> guessList = new ArrayList<>();
     
   //Random Generator
   private Random gen = new Random();
   private int numberOfCandy = gen.nextInt(200)+100;
 
   
   //Constructor
   public GumballGuessGUI(){
      //Null layout for absolute positioning
      setLayout(null);
      //Set Absolute positioning
      lblName.setBounds(10, 10, 100, 30);
      txtName.setBounds(120, 10, 150, 30);
      lblGuess.setBounds(10, 50, 100, 30);
      txtGuess.setBounds(120, 50, 150, 30);
      btnGuess.setBounds(160, 90, 110, 30);
      lblStats.setBounds(10, 140, 300, 60);
      btnCheckWinner.setBounds(160, 220, 110, 30);
   
      //Add components to window
      add(lblName);
      add(txtName);
      add(lblGuess);
      add(txtGuess);
      add(btnGuess);
      add(lblStats);
      add(btnCheckWinner);
      //Exit program when window closes
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(500, 400);
      window.add(this);
      window.setVisible(true);
      
      //Event for btnGuess
      btnGuess.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            String name = txtName.getText(); //gets the name
            int g = Integer.parseInt(txtGuess.getText());// get integer guess number and convert it from text to a int.
        	
            guess userGuess = new guess(name, g);//create a guess with the info from the text fields
            guessList.add(userGuess);
            
            txtName.setText("");
            txtGuess.setText("");
            
       
         }
      });


      btnCheckWinner.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
         guess winner = guessList.get(0);
         int closest = Math.abs(winner.getGuess() - numberOfCandy);
         
         for(guess g: guessList) {
        	 int dist = Math.abs(g.getGuess() - numberOfCandy);
        	 if (dist<closest) {
        		 winner = g;
        		 closest = dist;
        	 }//ends if
         }//ends loop
         lblStats.setText(winner.toString()+" candy was "+ numberOfCandy);
        
         
         }//action performed
      });

   }    
   
   public static void main(String [] args){
      new GumballGuessGUI();
   }
}