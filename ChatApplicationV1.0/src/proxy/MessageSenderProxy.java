package proxy;

import proxy.MessageSender;
public class MessageSenderProxy implements MessageSender {
    private RealMessageSender realMessageSender;
    private boolean hasPermission;

    public MessageSenderProxy(boolean hasPermission) {
        this.realMessageSender = new RealMessageSender();
        this.hasPermission = hasPermission;
    }

    @Override
    public void sendMessage(String message) {
        if (hasPermission) {
            System.out.println("Logging: Sending message");
            realMessageSender.sendMessage(message);
        } else {
            System.out.println("Access denied: You do not have permission to send messages.");
        }
    }
}
