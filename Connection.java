/*
 * class CONNECTION
 * Establishes socket with server
*/

// For Socket
import java.net.*;

// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class Connection {
    private Session _chatSession;

    private Socket _sessionSocket;
    private User user; // Person using program
    private User partner; // Interlocutor

    private final String REMOTE_HOST = "anon-chat-server.herokuapp.com";
    private final int REMOTE_PORT = 32990; 

    private InetAddress LOCAL_HOST;
    private final int LOCAL_PORT = 9090;


    public Connection(Session chatSession) {
        _chatSession = chatSession;
        establishConnection();
    }

    public void establishConnection() {
        try {
            if (_chatSession.LOCAL_TESTING) {
                LOCAL_HOST = InetAddress.getByName(null);
                _sessionSocket = new Socket(LOCAL_HOST, LOCAL_PORT);
            }
            else
                _sessionSocket = new Socket(REMOTE_HOST, REMOTE_PORT);

            ObjectOutputStream out =
                new ObjectOutputStream(_sessionSocket.getOutputStream());
            ObjectInputStream in =
                new ObjectInputStream(_sessionSocket.getInputStream());

            Thread sendMessages = new SendMessages(out);
            Thread receiveMessages = new ReceiveMessages(in);

            _chatSession.setThreads(sendMessages, receiveMessages);

        } catch (UnknownHostException e) {
            System.err.println("CONNECTION ERROR: Unknwown Host");
        } catch (Exception e) {
            System.err.println("CONNECTION ERROR: " + e);
        }
        
        user = new User();
        partner = new User ();
    }

    public User getUser() {
        return user;
    }

    public User getPartner() {
        return partner;
    }

}
