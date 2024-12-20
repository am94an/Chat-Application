package dao;

import util.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GroupDAO {
    private Connection connection;

    public GroupDAO() {
        this.connection = Database.getConnection();
    }

    
    public List<String[]> getUserGroupsWithTypes(String username) {
        List<String[]> groups = new ArrayList<>();
        String query = "SELECT g.GroupName, g.GroupType FROM groups g " +
                       "JOIN group_members gm ON g.GroupID = gm.GroupID " +
                       "JOIN Users u ON gm.UserID = u.UserID " +
                       "WHERE u.Username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String groupName = rs.getString("GroupName");
                String groupType = rs.getString("GroupType");
                groups.add(new String[]{groupName, groupType});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public boolean createGroup(String groupName, String groupType, String createdBy) {
        String query = "INSERT INTO groups (GroupName, GroupType, CreatedBy) VALUES (?, ?, (SELECT UserID FROM Users WHERE Username = ?))";
        String addMemberQuery = "INSERT INTO group_members (GroupID, UserID, Status) VALUES (?, (SELECT UserID FROM Users WHERE Username = ?), 'Active')";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, groupName);
            stmt.setString(2, groupType);
            stmt.setString(3, createdBy);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int groupID = generatedKeys.getInt(1);

                    try (PreparedStatement addMemberStmt = connection.prepareStatement(addMemberQuery)) {
                        addMemberStmt.setInt(1, groupID);
                        addMemberStmt.setString(2, createdBy);
                        addMemberStmt.executeUpdate();
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error while creating group: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean addMemberToGroup(String groupName, String username) {
        String query = "INSERT INTO group_members (GroupID, UserID) VALUES (" +
                       "(SELECT GroupID FROM groups WHERE GroupName = ?), " +
                       "(SELECT UserID FROM Users WHERE Username = ?))";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, groupName);
            stmt.setString(2, username);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeMemberFromGroup(String groupName, String username) {
        String query = "DELETE FROM group_members WHERE GroupID = (SELECT GroupID FROM groups WHERE GroupName = ?) " +
                       "AND UserID = (SELECT UserID FROM Users WHERE Username = ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, groupName);
            stmt.setString(2, username);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getGroupMembers(String groupName) {
        List<String> members = new ArrayList<>();
        String query = "SELECT u.Username FROM Users u " +
                       "JOIN group_members gm ON u.UserID = gm.UserID " +
                       "WHERE gm.GroupID = (SELECT GroupID FROM groups WHERE GroupName = ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, groupName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                members.add(rs.getString("Username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
    
    
    public boolean deleteGroup(String groupName, String username) {
        int groupID = getGroupIDByName(groupName);
        if (groupID == -1) {
            System.out.println("Group not found: " + groupName);
            return false;
        }

        if (!isUserAdmin(groupID, username)) {
            System.out.println("User is not authorized to delete this group.");
            return false;
        }

        try {
            PreparedStatement deleteMembersStmt = connection.prepareStatement(
                "DELETE FROM group_members WHERE GroupID = ?"
            );
            deleteMembersStmt.setInt(1, groupID);
            deleteMembersStmt.executeUpdate();

            PreparedStatement deleteGroupStmt = connection.prepareStatement(
                "DELETE FROM groups WHERE GroupID = ?"
            );
            deleteGroupStmt.setInt(1, groupID);
            int rowsAffected = deleteGroupStmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateGroup(String oldGroupName, String newGroupName, String newGroupType, String username) {
        int groupID = getGroupIDByName(oldGroupName);
        if (groupID == -1) {
            System.out.println("Group not found: " + oldGroupName);
            return false;
        }

        if (!isUserAdmin(groupID, username)) {
            System.out.println("User is not authorized to update this group.");
            return false;
        }

        String query = "UPDATE groups SET GroupName = ?, GroupType = ? WHERE GroupID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newGroupName);
            stmt.setString(2, newGroupType);
            stmt.setInt(3, groupID);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeUserFromGroup(String groupName, String username) {
        int groupID = getGroupIDByName(groupName);
        if (groupID == -1) {
            System.out.println("Group not found: " + groupName);
            return false;
        }

        try {
            PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM group_members WHERE GroupID = ? AND UserID = (SELECT UserID FROM Users WHERE Username = ?)"
            );
            stmt.setInt(1, groupID);
            stmt.setString(2, username);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getGroupIDByName(String groupName) {
        int groupID = -1;
        String query = "SELECT GroupID FROM Groups WHERE GroupName = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, groupName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                groupID = rs.getInt("GroupID");
                System.out.println("GroupID found: " + groupID);
            } else {
                System.out.println("Group not found: " + groupName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving GroupID: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return groupID;
    }

    public boolean isUserAdmin(int groupID, String username) {
        String query = "SELECT CreatedBy FROM groups WHERE GroupID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, groupID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int createdByUserID = rs.getInt("CreatedBy");
                int currentUserID = getUserIDByUsername(username);
                return createdByUserID == currentUserID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getUserIDByUsername(String username) {
        String query = "SELECT UserID FROM Users WHERE Username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("UserID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}