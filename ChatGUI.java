import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class ChatGUI extends JFrame implements ActionListener{
    static JFrame frame = new JFrame();
    static JButton send = new JButton("Send");
    public void actionPerformed(ActionEvent event){
	send.setText("Sent!");
    }
    public void go(){
	send.addActionListener(this);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 300);
	frame.setLocationRelativeTo( null );
	frame.getContentPane().add(send);
    }
    public static void main (String [] args){
	ChatGUI try1= new ChatGUI();
	try1.go();




	frame.setVisible(true);

    }
}
