package view;

import model.Message;
import observer.ChatObserver;
import controller.ChatSessionManager;
import util.Database;
import controller.GroupManager;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.Collections;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proxy.MessageSender;
import proxy.MessageSenderProxy;

public class ChatWindow extends JFrame implements ChatObserver {

    private JTextArea chatDisplay;
    private JTextField messageInputField;
    private JButton sendButton, sendImageButton, sendVideoButton;
    private String recipient;
    private String recipientType;
    private String username;
    private int groupID;
    private ChatSessionManager sessionManager = ChatSessionManager.getInstance();
    private Timer refreshTimer;
    private MessageSender messageSender;

    public ChatWindow(String title, int groupID) {
        super(title);
        this.groupID = groupID;
        this.messageSender = new MessageSenderProxy(true);
        chatDisplay = new JTextArea(20, 50);
        chatDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatDisplay);

        messageInputField = new JTextField(40);

        sendButton = new JButton("Send Text");
        sendButton.addActionListener(e -> sendTextMessage(username, recipientType, recipient, messageInputField, this));
        sendImageButton = new JButton("Send Image");
        sendImageButton.addActionListener(e -> sendMediaMessage(username, recipientType, recipient, this, "image"));

        sendVideoButton = new JButton("Send Video");
        sendVideoButton.addActionListener(e -> sendMediaMessage(username, recipientType, recipient, this, "video"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(messageInputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.WEST);
        bottomPanel.add(sendImageButton, BorderLayout.EAST);
        bottomPanel.add(sendVideoButton, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.recipient = "";

        refreshTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshChatHistory();
            }
        });
        refreshTimer.start();

        if ("Group".equalsIgnoreCase(recipientType)) {
            loadGroupChatHistory();
        } else if ("User".equalsIgnoreCase(recipientType)) {
            loadUserChatHistory();
        }
    }

    private void refreshChatHistory() {
        if ("Group".equalsIgnoreCase(recipientType)) {
            loadGroupChatHistory();
        } else if ("User".equalsIgnoreCase(recipientType)) {
            loadUserChatHistory();
        }
    }

    @Override
    public void update(String message) {
        chatDisplay.append(message + "\n");
        chatDisplay.setCaretPosition(chatDisplay.getDocument().getLength());
    }

    public void displayMessages(List<String> messages) {
        chatDisplay.setText("");
        for (String message : messages) {
            chatDisplay.append(message + "\n");
        }
    }

    public void updateChatHistory(List<String> messages) {
        for (String message : messages) {
            chatDisplay.append(message + "\n");
        }
        chatDisplay.setCaretPosition(chatDisplay.getDocument().getLength());
    }

public void sendTextMessage(String username, String recipientType, String recipient, JTextField messageField, ChatWindow chatWindow) {
    String messageContent = messageField.getText();
    if (!messageContent.isEmpty()) {
        String messageType = "text";
        Message message = factory.MessageFactory.createMessage(messageType, messageContent);

        if ("Group".equalsIgnoreCase(recipientType)) {
            
            sessionManager.addMessageToGroup(username, groupID, messageContent, messageType);
            System.out.println("Message sent to group with ID: " + groupID);

        } else if ("User".equalsIgnoreCase(recipientType)) {
            
            sessionManager.addMessageToUser(username, recipient, messageContent, messageType);
            System.out.println("Message sent to user: " + recipient);
        }

        
        messageSender.sendMessage(messageContent);
        chatWindow.updateChatHistory(Collections.singletonList(username + ": " + messageContent));
        messageField.setText("");  
    }
}
    public void sendMediaMessage(String username, String recipientType, String recipient, ChatWindow chatWindow, String mediaType) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select " + mediaType.substring(0, 1).toUpperCase() + mediaType.substring(1) + " File");
        String[] extensions = mediaType.equals("image") ? new String[]{"jpg", "jpeg", "png", "gif"} : new String[]{"mp4", "avi", "mov"};
        fileChooser.setFileFilter(new FileNameExtensionFilter(mediaType.substring(0, 1).toUpperCase() + mediaType.substring(1) + " Files", extensions));

        int result = fileChooser.showOpenDialog(chatWindow);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            String messageType = mediaType;
            Message message = factory.MessageFactory.createMessage(messageType, filePath);

            if ("Group".equals(recipientType)) {
                sessionManager.addMessageToGroup(username, groupID, filePath, messageType);
            } else if ("User".equals(recipientType)) {
                sessionManager.addMessageToUser(username, recipient, filePath, messageType);
            }

            message.sendMessage();
            chatWindow.updateChatHistory(Collections.singletonList(username + ": " + filePath));
        }
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        if (recipient != null && !recipient.isEmpty()) {
            this.recipient = recipient;
            System.out.println("Recipient set to: " + recipient);
        } else {
            System.out.println("Error: recipient cannot be null or empty.");
        }
    }

    public void setRecipientType(String recipientType) {
        if (recipientType != null && !recipientType.isEmpty()) {
            this.recipientType = recipientType;
            System.out.println("recipientType set to: " + recipientType);
        } else {
            System.out.println("Error: recipient cannot be null or empty.");
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void loadUserChatHistory() {
        if (username != null && recipient != null) {
            List<String> chatHistory = sessionManager.getUserChatHistory(username, recipient);
            displayMessages(chatHistory);
        } else {
            JOptionPane.showMessageDialog(this, "User or recipient is not set properly.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadGroupChatHistory() {
        if (groupID != -1) {
            List<String> chatHistory = sessionManager.getChatHistory(groupID);
            displayMessages(chatHistory);
        } else {
            JOptionPane.showMessageDialog(this, "Group ID is not set properly.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}