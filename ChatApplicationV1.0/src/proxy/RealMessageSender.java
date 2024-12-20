
package proxy;

import proxy.MessageSender;

public class RealMessageSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
    }
}