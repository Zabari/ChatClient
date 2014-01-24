/*
 * class MESSAGEDISPLAYER
 * Waits for new messages and adds to GUI
*/

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class MessageDisplayer extends Thread {
    MessageManager _messageManager;

    public MessageDisplayer(MessageManager messageManager) {
        _messageManager = messageManager;
    }

    public void run() {

    }
}
