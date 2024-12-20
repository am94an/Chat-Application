
package factory;

import model.Message;

public class ImageMessage extends Message {
    public ImageMessage(String content) {
        super(content);
    }
    
    @Override
    public void sendMessage() {
        System.out.println("Sending image message: " + content);
    }
}