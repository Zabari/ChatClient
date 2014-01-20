import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;*/
import javax.swing.*;
import java.awt.GridLayout;
public class ChatGUI extends JFrame{
    GridLayout g = new GridLayout(4,4);
    JFrame frame = new JFrame();
    
    JButton send = new JButton("Send");
    JTextField writeHere = new JTextField(290);
    String message;
    /* Session chatSession;
    public ChatGUI(Session x){
	chatSession=x;
	make();
    }
    */

    public class SentButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    message =  writeHere.getText();
	    writeHere.setText("");
		    System.out.println(message);
	}
    }
    public void make(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500, 500);
	frame.setLocationRelativeTo( null );
	frame.setLayout(g);
	frame.getContentPane().add(writeHere);
	frame.getContentPane().add(send);
	send.addActionListener(new SentButtonListener());
	writeHere.addActionListener (new ActionListener()
	    {
		public void actionPerformed(ActionEvent event){
		    message =  writeHere.getText();
		    writeHere.setText("");
		    System.out.println(message);
		}
	    });
	frame.setVisible(true);
    }
    public String getMessage(){
	return message;
    }
    public static void main (String [] args){
	ChatGUI gui= new ChatGUI();
	gui.make();




    }
}
