package game;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class HandleActionEventsForJButton extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = 1L;
 
    public HandleActionEventsForJButton() {
 
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
 
        JButton button1 = new JButton("Restart");
        JButton button2 = new JButton("Quit");
 
        //set action listeners for buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
 
        //add buttons to the frame
        add(button1);
        add(button2);
 
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Restart")) {
            System.out.println("resetting field...");
        }
        else if (action.equals("Quit")) {
            System.out.println("thanks for playing!");
        }
    }
 
    private static void createAndShowGUI() {
 
  //Create and set up the window.
 
  JFrame frame = new HandleActionEventsForJButton();
 
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