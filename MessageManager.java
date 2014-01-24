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

    private boolean incomingSignal = false;
    private boolean outgoingSignal = false;

    public MessageManager() {
        user = new User();
        partner = new User ();

        inbox = new ArrayBlockingQueue(20);
        outbox = new ArrayBlockingQueue(20);
    }

    public void sendMessage(String msgContent) {
	    //int senderID = user.getID();
	    //int receiverID = partner.getID();
        int senderID = 1;
        int receiverID = 2; // just for testing
	    long timestamp = System.currentTimeMillis() / 1000L;

        // Create new Message instance
        Message msgObject = new Message(
			 msgContent, senderID, receiverID, senderID);

        try {
        outbox.put(msgObject);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        outboxNotify();
    }

    public void inboxWait() {

    }

    public void inboxNotify() {

    }


    // Source: http://tutorials.jenkov.com/java-concurrency/thread-signaling.html#spuriouswakeups
    // Protected against missed signals and spurious wakeups
    // Technically unsafe to swallow InterruptedException:
    // http://www.ibm.com/developerworks/java/library/j-jtp05236/index.html
    public void outboxWait() {
        synchronized(outbox) {
            while (!outgoingSignal) {
                try {
                    outbox.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void outboxNotify() {
        synchronized(outbox) {
            outgoingSignal = true;
            outbox.notify();
        }
    }

    public Message getOutboxMessage(){
        try {
            return outbox.take();
        } catch (InterruptedException e) {
            System.out.println(e);
            return null;
        }
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
