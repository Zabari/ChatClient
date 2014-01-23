/*
 * class SendMessages
 * Sends messages through socket
*/

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class SendMessages extends Thread {
    ObjectOutputStream _out;

    public SendMessages(ObjectOutputStream out) {
        _out = out;
    }

    public void run() {

    }
}
