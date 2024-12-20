package dao;

import util.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDAO {
    private Connection connection;

    public ChatDAO() {
        this.connection = Database.getConnection();
    }

    public List<String> getChatHistory(int groupID) {
        List<String> chatHistory = new ArrayList<>();
        String query = "SELECT u.Username, m.Content FROM Messages m " +
                       "JOIN Users u ON m.SenderID = u.UserID " +
                       "WHERE m.GroupID = ? ORDER BY m.SentAt ASC";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, groupID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String userMessage = rs.getString("Username") + ": " + rs.getString("Content");
                chatHistory.add(userMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chatHistory;
    }

    public List<String> getUserChatHistory(String senderUsername, String receiverUsername) {
        List<String> chatHistory = new ArrayList<>();
        String query = "SELECT u.Username, m.Content FROM Messages m " +
                       "JOIN Users u ON m.SenderID = u.UserID " +
                       "WHERE (m.SenderID = (SELECT UserID FROM Users WHERE Username = ?) " +
                       "AND m.ReceiverID = (SELECT UserID FROM Users WHERE Username = ?)) " +
                       "OR (m.SenderID = (SELECT UserID FROM Users WHERE Username = ?) " +
                       "AND m.ReceiverID = (SELECT UserID FROM Users WHERE Username = ?)) " +
                       "ORDER BY m.SentAt ASC";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, senderUsername);
            stmt.setString(2, receiverUsername);
            stmt.setString(3, receiverUsername);
            stmt.setString(4, senderUsername);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String userMessage = rs.getString("Username") + ": " + rs.getString("Content");
                chatHistory.add(userMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chatHistory;
    }

        public void addMessageToGroup(String senderUsername, int groupID, String messageContent, String messageType) {
        String query = "INSERT INTO Messages (SenderID, GroupID, MessageType, Content) " +
                       "VALUES ((SELECT UserID FROM Users WHERE Username = ?), ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, senderUsername);
            stmt.setInt(2, groupID);
            stmt.setString(3, messageType);
            stmt.setString(4, messageContent);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error while inserting message into group: " + e.getMessage());
            e.printStackTrace();
        }
    }

public void addMessageToUser(String senderUsername, String receiverUsername, String message, String messageType) {
        String query = "INSERT INTO Messages (SenderID, ReceiverID, MessageType, Content) "
                + "VALUES ((SELECT UserID FROM Users WHERE Username = ?), "
                + "(SELECT UserID FROM Users WHERE Username = ?), ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, senderUsername);
            stmt.setString(2, receiverUsername);
            stmt.setString(3, messageType);  
            stmt.setString(4, message);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error while inserting message into user conversation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public List<String> getUserGroups(String username) {
        List<String> groups = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT g.GroupName "
                    + "FROM Groups g "
                    + "JOIN GroupMembers gm ON g.GroupID = gm.GroupID "
                    + "JOIN Users u ON gm.UserID = u.UserID "
                    + "WHERE u.Username = ?"
            );
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                groups.add(rs.getString("GroupName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    
    public List<String> getUserNames(String username) {
        List<String> users = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT u.Username "
                    + "FROM Users u "
                    + "JOIN Contacts c ON u.UserID = c.ContactUserID "
                    + "WHERE c.UserID = (SELECT UserID FROM Users WHERE Username = ?) "
                    + "AND c.Status = 'Active'"
            );
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(rs.getString("Username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}