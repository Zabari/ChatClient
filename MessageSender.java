/*
 * class MESSAGESENDER
 * Sends messages through socket
*/

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class MessageSender extends Thread {
    MessageManager _messageManager;
    ObjectOutputStream _out;

    public MessageSender(MessageManager messageManager, ObjectOutputStream out) {
        _messageManager = messageManager;
        _out = out;
    }

    public void run() {

    }
}
