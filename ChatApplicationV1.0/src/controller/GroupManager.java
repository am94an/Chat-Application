package controller;

import dao.GroupDAO;
import java.util.List;

public class GroupManager {
    private GroupDAO groupDAO;

    public GroupManager() {
        this.groupDAO = new GroupDAO();
    }

    public List<String[]> getUserGroupsWithTypes(String username) {
        return groupDAO.getUserGroupsWithTypes(username);
    }
    public int getGroupIDByName(String groupName) {
        return groupDAO.getGroupIDByName(groupName);
    }
    
      public boolean isUserAdmin(int groupID, String username) {
        return groupDAO.isUserAdmin(groupID, username);
    }
    
    public boolean createGroup(String groupName, String groupType, String createdBy) {
        return groupDAO.createGroup(groupName, groupType, createdBy);
    }

    public boolean addMemberToGroup(String groupName, String username) {
        return groupDAO.addMemberToGroup(groupName, username);
    }

    public boolean removeMemberFromGroup(String groupName, String username) {
        return groupDAO.removeMemberFromGroup(groupName, username);
    }

    public List<String> getGroupMembers(String groupName) {
        return groupDAO.getGroupMembers(groupName);
    }

    public boolean deleteGroup(String groupName, String username) {
        return groupDAO.deleteGroup(groupName, username);
    }

    public boolean updateGroup(String oldGroupName, String newGroupName, String newGroupType, String username) {
        return groupDAO.updateGroup(oldGroupName, newGroupName, newGroupType, username);
    }

    public boolean removeUserFromGroup(String groupName, String username) {
        return groupDAO.removeUserFromGroup(groupName, username);
    }
}