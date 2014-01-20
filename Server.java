public class Server {
    private Session _chatSession;

    public Server(Session chatSession) {
        _chatSession = chatSession;
    }

    public int[] establishConnection() {
        int[] userIDs = new int[2];
        userIDs[0] = 0; // test value
        userIDs[1] = 1; // test value
        return userIDs;
    }

    // Triggered by Session, which is triggered by GUI when user hits send
    public void sendMessage(String msg) {

    }
}
