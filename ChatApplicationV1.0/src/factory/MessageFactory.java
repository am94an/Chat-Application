package factory;

import factory.TextMessage;
import factory.ImageMessage;
import model.Message;

public class MessageFactory {
    public static Message createMessage(String type, String content) {
        if ("text".equals(type)) {
            return new TextMessage(content);  
        } else if ("image".equals(type)) {
            return new ImageMessage(content); 
        } else {
            return null;
        }
    }
}
