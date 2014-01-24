/*
 * class MESSAGERECEIVER
 * Checks for messages in socket
*/

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

import java.util.TimerTask;

public class MessageReceiver extends TimerTask {
    MessageManager _messageManager;
    ObjectInputStream _in;

    public MessageReceiver(MessageManager messageManager, ObjectInputStream in) {
        _messageManager = messageManager;
        _in = in;
    }

    public void run() {
        System.out.println("Checking inbox...");
        try {
            Message newMessage;
            while ((newMessage = (Message) _in.readObject()) != null) {
                System.out.println(newMessage);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
