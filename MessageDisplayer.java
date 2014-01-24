/*
 * class MESSAGEDISPLAYER
 * Waits for new messages and adds to GUI
*/

import javax.swing.SwingWorker;
import java.util.List;

public class MessageDisplayer extends SwingWorker<Void, Message> {
    MessageManager _messageManager;
    GUI _gui;

    public MessageDisplayer(MessageManager messageManager, GUI gui) {
        _messageManager = messageManager;
        _gui = gui;
    }

    @Override
    protected Void doInBackground() throws Exception {
        while (true) {
            _messageManager.inboxWait();

            // We awoke!
            Message incomingMsg = _messageManager.getInboxMessage();
            publish(incomingMsg);
        }
    }

    @Override
    protected void process(List<Message> incomingMsg) {
        _gui.getDisplay().append("Partner: "+ incomingMsg.get(0) + "\n");
    }
}
