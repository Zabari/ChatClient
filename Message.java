/*
 * class MESSAGE
 * Container for message content & metadata
*/

// Serializable is an interface that requires no methods to be implemented.
// It simply flags an object to be serializable. This is needed to send Messages
// through ObjectOutputStreams.

import java.io.Serializable;

public class Message implements Serializable {
    private String _content;
    private int _senderID; // assigned by server
    private int _receiverID; // assigned by server

    // Created through System.currentTimeMillis() / 1000L
    private long _timestamp;

    // Used to set Message IDs
    private static int numberSent;

    // Used to verify that no messages came before this one
    private int _id;

    // New Message object is created by GUI when sending message and by Server when receiving message
    public Message(String content, int senderID, int receiverID, long timestamp) {
        _content = content;
        _senderID = senderID;
        _receiverID = receiverID;
        _timestamp = timestamp;

        numberSent++;
        _id = numberSent;
    }

    public int getSenderID() {
        return _senderID;
    }

    public int getReceiverID() {
        return _receiverID;
    }

    public long getTimestamp() {
        return _timestamp;
    }

    public String toString() {
        return _content;
    }
}
