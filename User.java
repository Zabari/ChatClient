/*
 * class USER
 * Users and their metadata
*/

public class User {
    private int _ID; // Unique identifier for Server

    public User(int ID) {
        _ID = ID;
    }

    public int getID() {
        return _ID;
    }
}
