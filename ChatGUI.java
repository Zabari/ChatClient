import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.GridLayout;
/*
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;*/
import javax.swing.*;
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
	    writeHere = new JTextField(290);
	}
    }
    public void make(){
	send.addActionListener(new SentButtonListener());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500, 500);
	frame.setLocationRelativeTo( null );
	frame.setLayout(g);
	frame.getContentPane().add(send);
	frame.setVisible(true);
    }
    public String getMessage(){
	return message;
    }
    public static void main (String [] args){
	ChatGUI gui= new ChatGUI();
	gui.make();
	gui.getMessage();




    }
}
