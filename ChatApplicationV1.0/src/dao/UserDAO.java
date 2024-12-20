
package dao;
import model.User;
import util.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        this.connection = Database.getConnection();
    }

    public boolean login(String username, String passwordHash) {
        String query = "SELECT * FROM users WHERE Username = ? AND PasswordHash = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, passwordHash);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String signUp(String username, String email, String passwordHash, String profilePicture, String status) {
        String errorMessage = null;
        String query = "INSERT INTO Users (Username, Email, PasswordHash, ProfilePicture, Status) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, passwordHash);
            pstmt.setString(4, profilePicture);
            pstmt.setString(5, status);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            errorMessage = ex.getMessage(); 
            System.out.println("Error during sign-up: " + ex.getMessage());
        }
        
        return errorMessage; 
    }

public User getUserByUsername(String username) {
    String query = "SELECT * FROM Users WHERE Username = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(
                rs.getInt("UserID"),
                rs.getString("Username"),
                rs.getString("PasswordHash"),
                rs.getString("Email"),
                rs.getString("ProfilePicture"),
                rs.getString("Status")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}
