import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import org.jdesktop.xswingx.*;

/*
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;*/
import javax.swing.*;
import java.awt.GridLayout;
public class ChatGUI extends JFrame{

    GridLayout g = new GridLayout(3,4);
    JFrame frame = new JFrame();
    JTextArea display = new JTextArea();
    JButton send = new JButton("Send");
    JButton log = new JButton("See your chat so far!");
    JTextArea writeHere = new JTextArea();

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
	    /*
	    try(PrintWriter chatLog = new PrintWriter(new BufferedWriter(new FileWriter("ChatLog.txt", true)))) {
		    chatLog.println("You: "+message);
		}
	    catch (IOException ex)  {
		System.out.println("Could not open file.  Try running as administrator or root.");
	    } */
	    if (message.trim().length()>0)
		display.append("You: "+message.replaceFirst("\\s+$", "")+"\n");
	}
    }
    public void make(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500, 500);
	frame.setLocationRelativeTo( null );
	frame.setLayout(g);
	frame.getContentPane().add(new JScrollPane(display));
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
	display.setEditable(false);
	frame.getContentPane().add(new JScrollPane(writeHere));
        writeHere.setLineWrap(true);
        writeHere.setWrapStyleWord(true);
	frame.getContentPane().add(send);
	PromptSupport.setPrompt("Type Here!",writeHere);
	//	frame.getContentPane().add(log);
	/*	log.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e){
		    File cLog=new File("Chatlog.txt"); 
		    try{
		    java.awt.Desktop.getDesktop().edit(cLog);
		    }
		    catch (IOException ex){
		    }
		}
		}); */

	send.addActionListener(new SentButtonListener());
	/*	writeHere.addActionListener (new ActionListener()
	    {
		public void actionPerformed(ActionEvent event){
		    message =  writeHere.getText();
		    writeHere.setText("");
		    display.setText("You: "+message);
		    try(PrintWriter chatLog = new PrintWriter(new BufferedWriter(new FileWriter("ChatLog.txt", true)))) {
			    chatLog.println("You: "+message);
			}
		    catch (IOException ex)  {
			System.out.println("Could not open file.  Try running as administrator or root.");
		    }
		}
		}); */
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
