package factory;

import model.Message;


public class VideoMessage extends Message {
    public VideoMessage(String content) {
        super(content);
    }

    @Override
    public void sendMessage() {
        System.out.println("Sending video message: " + content);
    }
}