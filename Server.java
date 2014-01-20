/*
 * class SERVER
 * Sends and receives messages
*/

public class Server {
    private Session _chatSession;
    private User _user;
    private User _partner;

    public Server(Session chatSession) {
        _chatSession = chatSession;
    }

    public int[] establishConnection() {
        int[] userIDs = new int[2];
        userIDs[0] = 0; // test value
        userIDs[1] = 1; // test value
        return userIDs;
    }

    public void setUsers(User user, User partner) {
        _user = user;
        _partner = partner;
    }

    // Triggered by Session, which is triggered by GUI when user hits send
    public void sendMessage(Message msg) {

    }
}
