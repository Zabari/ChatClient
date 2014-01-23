/*
 * class ReceiveMessages
 * Checks for messages in socket
*/

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class ReceiveMessages extends Thread {
    ObjectInputStream _in;

    public ReceiveMessages(ObjectInputStream in) {
        _in = in;
    }

    public void run() {

    }
}
