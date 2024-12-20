
package view;

import util.Database;
import controller.GroupManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Groups extends javax.swing.JFrame {
    private String username;
    private DefaultTableModel tableModel;
    private GroupManager groupManager;

    public void setUsername(String username) {
        this.username = username;
        loadGroups();
    }

    public Groups() {
        groupManager = new GroupManager();
        initComponents();
        tableModel = new DefaultTableModel();
        jTableGroup.setModel(tableModel);
        loadGroups();
    }
    
    private void loadGroups() {
        if (username != null) {
            List<String[]> groups = groupManager.getUserGroupsWithTypes(username);

            tableModel.setRowCount(0);  
            tableModel.setColumnCount(0);

            tableModel.addColumn("Group Name");
            tableModel.addColumn("Group Type");

            for (String[] group : groups) {
                tableModel.addRow(new Object[]{group[0], group[1]});
            }

            System.out.println("Loaded groups: " + groups);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonAddGroup = new javax.swing.JButton();
        jButtonDelGroup = new javax.swing.JButton();
        jButtonEditGroup = new javax.swing.JButton();
        jButtonManageGroup = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGroup = new javax.swing.JTable();
        jButtonOpenchat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Groups management");
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list of members.png"))); // NOI18N
        jLabel1.setText("Groups Management");

        jButtonAddGroup.setText("Add Group");
        jButtonAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGroupActionPerformed(evt);
            }
        });

        jButtonDelGroup.setText("Delet Group");
        jButtonDelGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelGroupActionPerformed(evt);
            }
        });

        jButtonEditGroup.setText("Edit Group");
        jButtonEditGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditGroupActionPerformed(evt);
            }
        });

        jButtonManageGroup.setBackground(new java.awt.Color(204, 204, 204));
        jButtonManageGroup.setText("Manage Member");
        jButtonManageGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageGroupActionPerformed(evt);
            }
        });

        jTableGroup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "GroupName", "GroupType"
            }
        ));
        jScrollPane2.setViewportView(jTableGroup);

        jButtonOpenchat.setBackground(new java.awt.Color(204, 204, 204));
        jButtonOpenchat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonOpenchat.setText("Open Chat");
        jButtonOpenchat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOpenchatMouseClicked(evt);
            }
        });
        jButtonOpenchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenchatActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonManageGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonEditGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonDelGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAddGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOpenchat, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButtonAddGroup)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonDelGroup)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonEditGroup)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonManageGroup)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonOpenchat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditGroupActionPerformed
        int selectedRow = jTableGroup.getSelectedRow();
        if (selectedRow != -1) {
            String oldGroupName = (String) tableModel.getValueAt(selectedRow, 0);
            String newGroupName = JOptionPane.showInputDialog(null, "Enter new group name:", oldGroupName);
            if (newGroupName == null || newGroupName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Group name cannot be empty.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String[] groupTypes = {"Public", "Private", "Admin"};
            String newGroupType = (String) JOptionPane.showInputDialog(null, "Select new group type:", "Edit Group",
                    JOptionPane.PLAIN_MESSAGE, null, groupTypes, groupTypes[0]);
            if (newGroupType == null) {
                JOptionPane.showMessageDialog(null, "Group type must be selected.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean success = groupManager.updateGroup(oldGroupName, newGroupName, newGroupType, username);
            if (success) {
                JOptionPane.showMessageDialog(null, "Group updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadGroups(); // إعادة تحميل المجموعات لتحديث العرض
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update group. You may not have permission.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a group to edit.", "No Group Selected", JOptionPane.WARNING_MESSAGE);
        }
    
    }//GEN-LAST:event_jButtonEditGroupActionPerformed
    
private void openGroupChatWindow(String username, String groupName) {
    int groupID = groupManager.getGroupIDByName(groupName);
    if (groupID == -1) {
        JOptionPane.showMessageDialog(this, "Group not found.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ChatWindow chatWindow = new ChatWindow("Chat with " + groupName, groupID);
    chatWindow.setUsername(username);
    chatWindow.setRecipientType("Group");

    chatWindow.setVisible(true);
    chatWindow.loadGroupChatHistory();
}

    private void jButtonAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGroupActionPerformed
    String groupName = JOptionPane.showInputDialog(this, "Enter group name:", "Add Group", JOptionPane.PLAIN_MESSAGE);
    if (groupName == null || groupName.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Group name cannot be empty.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String[] groupTypes = {"Public", "Private", "Admin"};
    String groupType = (String) JOptionPane.showInputDialog(this, "Select group type:", "Add Group",
            JOptionPane.PLAIN_MESSAGE, null, groupTypes, groupTypes[0]);
    if (groupType == null) {
        JOptionPane.showMessageDialog(this, "Group type must be selected.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    boolean success = groupManager.createGroup(groupName, groupType, username);
    if (success) {
        JOptionPane.showMessageDialog(this, "Group added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        loadGroups();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to add group. It may already exist or an error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonAddGroupActionPerformed

    private void jButtonOpenchatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOpenchatMouseClicked
        int selectedRow = jTableGroup.getSelectedRow();

        if (selectedRow != -1) {
            String selectedGroup = (String) tableModel.getValueAt(selectedRow, 0);
            System.out.println("Selected group: " + selectedGroup);

            if (selectedGroup != null && !selectedGroup.isEmpty()) {
                openGroupChatWindow(username, selectedGroup);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a group to open a chat.", "No Group Selected", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a group to open a chat.", "No Group Selected", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButtonOpenchatMouseClicked

    private void jButtonOpenchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOpenchatActionPerformed

    private void jButtonDelGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelGroupActionPerformed
        int selectedRow = jTableGroup.getSelectedRow();
        if (selectedRow != -1) {
            String selectedGroup = (String) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the group: " + selectedGroup + "?", "Delete Group", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = groupManager.deleteGroup(selectedGroup, username);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Group deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadGroups(); // إعادة تحميل المجموعات لتحديث العرض
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete group. You may not have permission.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a group to delete.", "No Group Selected", JOptionPane.WARNING_MESSAGE);
        }
    
    }//GEN-LAST:event_jButtonDelGroupActionPerformed

    private void jButtonManageGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageGroupActionPerformed
    int selectedRow = jTableGroup.getSelectedRow();
    if (selectedRow != -1) {
        String selectedGroup = (String) tableModel.getValueAt(selectedRow, 0);
        int groupID = groupManager.getGroupIDByName(selectedGroup);

        if (groupManager.isUserAdmin(groupID, username)) {
            openGroupManagementWindow(selectedGroup);
        } else {
            JOptionPane.showMessageDialog(null, "You do not have permission to manage this group.", "Access Denied", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a group to manage.", "No Group Selected", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButtonManageGroupActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            setVisible (false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

private void openGroupManagementWindow(String groupName) {
    JFrame managementFrame = new JFrame("Manage Group: " + groupName);
    managementFrame.setSize(400, 300);
    managementFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    managementFrame.setLayout(new BorderLayout());

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 1));

    JButton addMemberButton = new JButton("Add Member");
    addMemberButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String newMember = JOptionPane.showInputDialog(managementFrame, "Enter username to add:", "Add Member", JOptionPane.PLAIN_MESSAGE);
            if (newMember != null && !newMember.trim().isEmpty()) {
                boolean success = groupManager.addMemberToGroup(groupName, newMember);
                if (success) {
                    JOptionPane.showMessageDialog(managementFrame, "Member added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(managementFrame, "Failed to add member. User may not exist or is already a member.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });

    JButton removeMemberButton = new JButton("Remove Member");
    removeMemberButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String memberToRemove = JOptionPane.showInputDialog(managementFrame, "Enter username to remove:", "Remove Member", JOptionPane.PLAIN_MESSAGE);
            if (memberToRemove != null && !memberToRemove.trim().isEmpty()) {
                boolean success = groupManager.removeMemberFromGroup(groupName, memberToRemove);
                if (success) {
                    JOptionPane.showMessageDialog(managementFrame, "Member removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(managementFrame, "Failed to remove member. User may not exist or is not a member.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });


    panel.add(addMemberButton);
    panel.add(removeMemberButton);

    managementFrame.add(panel, BorderLayout.CENTER);
    managementFrame.setVisible(true);
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAddGroup;
    private javax.swing.JButton jButtonDelGroup;
    private javax.swing.JButton jButtonEditGroup;
    private javax.swing.JButton jButtonManageGroup;
    private javax.swing.JButton jButtonOpenchat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGroup;
    // End of variables declaration//GEN-END:variables
}
