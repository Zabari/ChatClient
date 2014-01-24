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

    }
}
