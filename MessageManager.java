/*
 * class MESSAGEMANAGER
 * Controls message queues
*/

// For BlockingQueue, ArrayBlockingQueue
import java.util.concurrent.*;

public class MessageManager {

    private Connection _connection;
        
    private User user; // Person using program
    private User partner; // Interlocutor

    private BlockingQueue<Message> inbox;
    private BlockingQueue<Message> outbox;

    private boolean newIncomingSignal = false;
    private boolean newOutgoingSignal = false;

    public MessageManager() {
        user = new User();
        partner = new User ();

        inbox = new ArrayBlockingQueue(20);
        outbox = new ArrayBlockingQueue(20);
    }

    public void sendMessage(String msgContent) {
	    //int senderID = _connecion.getUser().getID();
	    //int receiverID = _connection.getPartner.getID();
        int senderID = 1;
        int receiverID = 2; // just for testing
	    long timestamp = System.currentTimeMillis() / 1000L;

        // Create new Message instance
        Message msgObject = new Message(
			 msgContent, senderID, receiverID, senderID);
    }

    public void inboxWait() {

    }

    public void inboxNotify() {

    }

    public void outboxWait() {

    }

    public void outboxNotify() {

    }

    public void setConnection(Connection connection) {
        _connection = connection;
    }

    public User getUser() {
        return user;
    }

    public User getPartner() {
        return partner;
    }
    
}
