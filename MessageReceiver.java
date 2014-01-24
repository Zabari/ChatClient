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
        Message newMessage;
        try {
            // Hangs; see my SO question: http://stackoverflow.com/q/21323543/805556
            newMessage = (Message) _in.readObject();
            System.out.println(newMessage);
        } catch (EOFException e) {
            System.out.println("EOF");
            break;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
