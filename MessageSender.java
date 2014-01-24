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
        while (true) {
            _messageManager.outboxWait();

            // We awoke!
            Message outgoingMsg = _messageManager.getOutboxMessage();
            try {
                _out.writeObject(outgoingMsg);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
