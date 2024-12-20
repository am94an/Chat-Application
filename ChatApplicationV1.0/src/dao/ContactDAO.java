package dao;

import util.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private Connection connection;

    public ContactDAO() {
        this.connection = Database.getConnection();
    }

    public List<String> getUserContacts(String username) {
        List<String> contacts = new ArrayList<>();
        String query = "SELECT u.Username " +
                       "FROM Users u " +
                       "JOIN Contacts c1 ON u.UserID = c1.ContactUserID " +
                       "WHERE c1.UserID = (SELECT UserID FROM Users WHERE Username = ?) " +
                       "AND c1.Status = 'Active'";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String contact = rs.getString("Username");
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public boolean addContact(String username, String contactUsername) {
        String query = "INSERT INTO Contacts (UserID, ContactUserID, Status) " +
                       "VALUES ((SELECT UserID FROM Users WHERE Username = ?), " +
                       "(SELECT UserID FROM Users WHERE Username = ?), 'Active')";
        try (PreparedStatement stmt1 = connection.prepareStatement(query);
             PreparedStatement stmt2 = connection.prepareStatement(query)) {
            stmt1.setString(1, username);
            stmt1.setString(2, contactUsername);
            stmt1.executeUpdate();

            stmt2.setString(1, contactUsername);
            stmt2.setString(2, username);
            stmt2.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteContact(String username, String contactUsername) {
        String query = "DELETE FROM Contacts WHERE UserID = (SELECT UserID FROM Users WHERE Username = ?) " +
                       "AND ContactUserID = (SELECT UserID FROM Users WHERE Username = ?)";
        try (PreparedStatement stmt1 = connection.prepareStatement(query);
             PreparedStatement stmt2 = connection.prepareStatement(query)) {
            stmt1.setString(1, username);
            stmt1.setString(2, contactUsername);
            int rowsAffected1 = stmt1.executeUpdate();

            stmt2.setString(1, contactUsername);
            stmt2.setString(2, username);
            int rowsAffected2 = stmt2.executeUpdate();

            return rowsAffected1 > 0 && rowsAffected2 > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editContact(String username, String oldContactUsername, String newContactUsername) {
        String query = "UPDATE Contacts SET ContactUserID = (SELECT UserID FROM Users WHERE Username = ?) " +
                       "WHERE UserID = (SELECT UserID FROM Users WHERE Username = ?) " +
                       "AND ContactUserID = (SELECT UserID FROM Users WHERE Username = ?)";
        try (PreparedStatement stmt1 = connection.prepareStatement(query);
             PreparedStatement stmt2 = connection.prepareStatement(query)) {
            stmt1.setString(1, newContactUsername);
            stmt1.setString(2, username);
            stmt1.setString(3, oldContactUsername);
            int rowsAffected1 = stmt1.executeUpdate();

            stmt2.setString(1, newContactUsername);
            stmt2.setString(2, oldContactUsername);
            stmt2.setString(3, username);
            int rowsAffected2 = stmt2.executeUpdate();

            return rowsAffected1 > 0 && rowsAffected2 > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}