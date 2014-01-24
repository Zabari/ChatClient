/*
 * class CONNECTION
 * Establishes socket with server
*/

// For Socket
import java.net.*; 
//
// For ObjectInputStream, ObjectOutputStream
import java.io.*;

public class Connection {

    private Chat _chatSession;
    private Socket _sessionSocket;

    public final boolean LOCAL_TESTING = true;

    private final String REMOTE_HOST = "anon-chat-server.herokuapp.com";
    private final int REMOTE_PORT = 32990; 

    private InetAddress LOCAL_HOST;
    private final int LOCAL_PORT = 9090;


    public Connection(Chat chatSession) {
        _chatSession = chatSession;
        connectToServer();
    }

    public void connectToServer() {
        try {
            if (LOCAL_TESTING) {
                LOCAL_HOST = InetAddress.getByName(null);
                _sessionSocket = new Socket(LOCAL_HOST, LOCAL_PORT);
            }
            else
                _sessionSocket = new Socket(REMOTE_HOST, REMOTE_PORT);

            ObjectOutputStream out =
                new ObjectOutputStream(_sessionSocket.getOutputStream());
            ObjectInputStream in =
                new ObjectInputStream(_sessionSocket.getInputStream());

            _chatSession.createThreads(out, in);

        } catch (UnknownHostException e) {
            System.err.println("CONNECTION ERROR: Unknwown Host");
        } catch (Exception e) {
            System.err.println("CONNECTION ERROR: " + e);
        }
    }

}
