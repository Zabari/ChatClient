/*
 * class MESSAGE
 * Container for message content & metadata
*/

public class Message {
    private String _content;
    private int _senderID;
    private int _receiverID;

    // Created through System.currentTimeMillis() / 1000L
    private long _timestamp;

    // New Message object is created by GUI when sending message and by Server when receiving message
    public Message(String content, int senderID, int receiverID, long timestamp) {
        _content = content;
        _senderID = senderID;
        _receiverID = receiverID;
        _timestamp = timestamp;
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
