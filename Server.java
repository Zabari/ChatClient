public class Server {
    private Session _chatSession;
    public Server(Session chatSession) {
        _chatSession = chatSession;
    }

    public int[] establishConnection() {
        int userIDs = new int[2];
        userIDs[0] = 0;
        userIDs[1] = 1;
        return userIDs;
    }

    public void sendMessage(String msg) {

    }
}
