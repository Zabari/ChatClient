/*
 * class SESSION
 * Command center of program
*/

public class Session {
    GUI sessionGUI; // Interface
    Server sessionServer; // Server
    User user; // Person using program
    User partner; // Interlocutor

    public void start() {
        createConnection();
        createGUI();
    }

    public void createConnection() {
        sessionServer = new Server(this);

        // Server returns array of ints, containing IDs of users
        int[] userIDs = sessionServer.establishConnection(); 
        user = new User(userIDs[0]); // Create user and store ID
        partner = new User (userIDs[1]); // Create interlocutor and store ID

        sessionServer.setUsers(user, partner);
    }

    public void createGUI() {
        sessionGUI = new GUI(this, user, partner);
    }

    // triggered by sessionGUI
    public void sendMessage(Message msg) { 
        sessionServer.sendMessage(msg);
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
