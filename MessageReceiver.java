/*
 * class MESSAGERECEIVER
 * Checks for messages in socket
*/

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class MessageReceiver extends Thread {
    MessageManager _messageManager;
    ObjectInputStream _in;

    public MessageReceiver(MessageManager messageManager, ObjectInputStream in) {
        _messageManager = messageManager;
        _in = in;
    }

    public void run() {
        while (true) {
            Message incomingMsg;
            try {
                incomingMsg = (Message) _in.readObject();
                System.out.println("Server: " + incomingMsg);
                _messageManager.displayMessage(incomingMsg);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
