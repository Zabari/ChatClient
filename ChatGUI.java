import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import org.jdesktop.xswingx.*;

import javax.swing.*;
import java.awt.GridLayout;
public class ChatGUI extends JFrame {

    GridLayout g = new GridLayout(3,4);
    JFrame frame = new JFrame();

    JTextArea display = new JTextArea();
    JButton send = new JButton("Send");
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
            if (message.trim().length() > 0)
                display.append("You: "+ message.replaceFirst("\\s+$", "") + "\n");
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
        send.addActionListener(new SentButtonListener());

        frame.setVisible(true);
    }

    public String getMessage(){
        return message;
    }

    public static void main (String[] args){
        ChatGUI gui= new ChatGUI();
        gui.make();
    }
}
