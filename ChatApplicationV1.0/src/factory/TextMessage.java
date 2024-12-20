
package factory;

import model.Message;


public class TextMessage extends Message {
    public TextMessage(String content) {
        super(content);
    }

    @Override
    public void sendMessage() {
    }
}
