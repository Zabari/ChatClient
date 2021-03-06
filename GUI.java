/*
 * class GUI
 * Interface of chat program
*/

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

public class GUI implements ActionListener /* ActionListener is an abstract interface, consisting of one method actionPerformed(ActionEvent e).  This method must be over-written in any classes implementing ActionListener.  This method is then associated with an event (JButton, JFrame, etc.), which then "listens" (i.e. makes sure something is done when a button is pressed, etc) */  {

    private MessageManager _messageManager;

    private GridLayout g = new GridLayout(3,4); /*GridLayout implements LayoutManager and Serializable.  It must implement LayoutManager, because LayoutManager allows you to manage the layout (whoa!) of a JFrame.  GridLayout then must over-write all of the methods in LayoutManager, and then is allowed to create a layout for a Container, such as JFrame.  Serializable allows any class implementing it, to be serialized.  Serialization is the storing of an object in its state, in a transmittable file.  If an object is serialized, it can be opened on different computers in the same way.  GridLayout needs to implement this so it doesn't come out wonky on different computers. */
    private JFrame frame = new JFrame();

    private JTextArea display = new JTextArea();
    private JButton send = new JButton("Send");
    private JTextArea writeHere = new JTextArea();
    private String message;

    public GUI() { }

    // GUI is created by Session
    public GUI (MessageManager messageManager) {
        _messageManager = messageManager;
        make();
    }

    public void actionPerformed(ActionEvent event){
        message =  writeHere.getText();
        writeHere.setText("");
        if (message.trim().length() > 0) {

            // Remove trailing whitespace
            String msgContent = message.replaceFirst("\\s+$", ""); 

            // Add user's message to GUI
            display.append("You: "+ msgContent + "\n");

            // Pass it on to MessageManager
            _messageManager.sendMessage(msgContent);

        }
    }

    private void make(){
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
        send.addActionListener(this);

        frame.setVisible(true);
    }

    public String getMessage(){
        return message;
    }

    public JTextArea getDisplay() {
        return display;
    }

    public static void main (String[] args){
        GUI testGUI = new GUI();
    }
}
