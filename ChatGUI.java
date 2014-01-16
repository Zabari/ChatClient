import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;*/
import javax.swing.*;
public class ChatGUI extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
    JButton send = new JButton("Send");
    JTextField writeHere = new JTextField(290);
    Session chatSession;
    public ChatGUI(Session x){
	chatSession=x;
    }

    public class SentButtonListener{
	public void actionPerformed(ActionEvent event){
	    send.setText("Sent!");
	}
    }
    public class TextBoxListener{
	public void actionPerformed(ActionEvent event){
	}
    }
    public void make(){
	send.addActionListener(new SentButtonListener());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 300);
	frame.setLocationRelativeTo( null );
	frame.getContentPane().add(send);
	frame.setVisible(true);
    }
    public static void main (String [] args){
	ChatGUI gui= new ChatGUI();
	gui.make();





    }
}
