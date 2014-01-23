/*
 * class SESSION
 * Command center of program
*/

// For BlockingQueue, ArrayBlockingQueue
import java.util.concurrent.*;
//
// For Socket
import java.net.*;

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class Session {
    public final boolean LOCAL_TESTING = true;

    private GUI sessionGUI; // Interface
    private Connection sessionConnection;

    private Thread _sendMessages;
    private Thread _receiveMessages;

    private BlockingQueue<Message> incoming = new ArrayBlockingQueue(20);
    private BlockingQueue<Message> outgoing = new ArrayBlockingQueue(20);


    public void start() {
        createGUI();
        createConnection();
    }

    public void createGUI() {
        sessionGUI = new GUI(this);
    }

    public void createConnection() {
        sessionConnection = new Connection(this);
    }

    public void setThreads(Thread sendMessages, Thread receiveMessages) {
        _sendMessages = sendMessages;
        _receiveMessages = receiveMessages;
    }

    // triggered by GUI
    public void sendMessage(Message msg) { 
    }

    // triggered by Server, passes on to GUI
    public void displayMessage(Message msg) {
        sessionGUI.displayMessage(msg);
    }

    public static void main(String[] args) {
        Session chatSession = new Session();
        chatSession.start();
    }
}
