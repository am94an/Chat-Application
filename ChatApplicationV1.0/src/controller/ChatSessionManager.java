package controller;

import dao.ChatDAO;
import java.util.List;

public class ChatSessionManager {
    private static ChatSessionManager instance;
    private ChatDAO chatDAO;

    private ChatSessionManager() {
        this.chatDAO = new ChatDAO();
    }

    public static ChatSessionManager getInstance() {
        if (instance == null) {
            instance = new ChatSessionManager();
        }
        return instance;
    }

    public List<String> getChatHistory(int groupID) {
        return chatDAO.getChatHistory(groupID);
    }

    public List<String> getUserChatHistory(String senderUsername, String receiverUsername) {
        return chatDAO.getUserChatHistory(senderUsername, receiverUsername);
    }

       public void addMessageToGroup(String senderUsername, int groupID, String messageContent, String messageType) {
        chatDAO.addMessageToGroup(senderUsername, groupID, messageContent, messageType);
    }
 
    public void addMessageToUser(String senderUsername, String receiverUsername, String message, String messageType) {
        chatDAO.addMessageToUser(senderUsername, receiverUsername, message, messageType);
    }

    public List<String> getUserGroups(String username) {
        return chatDAO.getUserGroups(username);
    }

    public List<String> getUserNames(String username) {
        return chatDAO.getUserNames(username);
    }
}