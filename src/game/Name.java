package game;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
 
public class Name extends JFrame {
 
    private static final long serialVersionUID = 1L;
    public Name() {
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
 
 
        // create JTextField with default text
        JTextField field1 = new JTextField("Player 1 Name");
 
        // create JTextField with specified number of columns
        JTextField field2 = new JTextField("Player 2 Name");
        // add textfields to frame
        add(field1);
        add(field2);
 
    }
 
    private static void createAndShowGUI() {
 
  //Create and set up the window.
 
  JFrame frame = new Name();
 
  //Display the window.
 
  frame.pack();
 
  frame.setVisible(true);
 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
 
    }
 
    public static void main(String[] args) {
 
  //Schedule a job for the event-dispatching thread:
 
  //creating and showing this application's GUI.
 
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
public void run() {
 
    createAndShowGUI(); 
 
}
 
  });
    }
 
}