/*
 * class SESSION
 * Command center of program
*/

public class Session {
    GUI sessionGUI; // GUI
    Server sessionServer; // Server
    User user; // Person using program
    User partner; // Interlocutor

    public void start() {
        createConnection();
        createGUI();
    }

    public void createConnection() {
        sessionServer = new Server(this);

        // Returns array of ints, containing IDs of users
        int[] userIDs = sessionServer.establishConnection(); 
        user = new User (userIDs[0]); // Create user and store ID
        partner = new User (userIDs[1]); // Create interlocutor and store ID
    }

    public void createGUI() {
        sessionGUI = new GUI(this);
    }

    // triggered by sessionGUI
    public void sendMessage(String msg) { 
        sessionServer.sendMessage(msg);
    }

    // triggered by Server
    public void displayMessage(String msg) {
        sessionGUI.displayMessage(msg);
    }

    public static void main(String[] args) {
        Session chatSession = new Session();
        chatSession.start();
    }
}
