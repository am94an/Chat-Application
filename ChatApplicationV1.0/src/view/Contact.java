package view;

import controller.ContactManager;
import util.Database;


import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.util.List;
import javax.swing.JOptionPane;

public class Contact extends javax.swing.JFrame {
    private String username;
    private DefaultListModel<String> contactListModel;
    private JList<String> contactList;
    private ContactManager contactManager;
    
    public void setUsername(String username) {
        this.username = username;
        loadContacts();
    }

public Contact() {
    initComponents(); 
    contactListModel = new DefaultListModel<>();
    contactList = new JList<>(contactListModel);
    jList1.setModel(contactListModel);  
    contactManager = new ContactManager();
}

private void loadContacts() {
    if (username != null) {
        List<String> contacts = contactManager.getUserContacts(username);
        contactListModel.clear();  // Clear old data
        System.out.println("Loaded contacts: " + contacts);  // Debug log
        for (String contact : contacts) {
            contactListModel.addElement(contact);
        }
    }
}
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonAddContact = new javax.swing.JButton();
        jButtonDelContact = new javax.swing.JButton();
        jButtonOpenchat = new javax.swing.JButton();
        jButtonEditContact = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contacts managment");
        setLocation(new java.awt.Point(375, 200));
        setUndecorated(true);

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update & delete member.png"))); // NOI18N
        jLabel1.setText("Contacts management");
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 20));

        jButtonAddContact.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAddContact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAddContact.setText("Add content");
        jButtonAddContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddContactActionPerformed(evt);
            }
        });

        jButtonDelContact.setBackground(new java.awt.Color(204, 204, 204));
        jButtonDelContact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDelContact.setText("Delete content");
        jButtonDelContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelContactActionPerformed(evt);
            }
        });

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

        jButtonEditContact.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEditContact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEditContact.setText("Edit content");
        jButtonEditContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditContactActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDelContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditContact, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonOpenchat, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(9, 9, 9)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAddContact)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonDelContact)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonEditContact)
                        .addGap(47, 47, 47)
                        .addComponent(jButtonOpenchat))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDelContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelContactActionPerformed
        String selectedContact = jList1.getSelectedValue();  
    System.out.println("Selected contact: " + selectedContact);

    if (selectedContact != null && !selectedContact.isEmpty()) {
        int confirmDelete = javax.swing.JOptionPane.showConfirmDialog(
            Contact.this,
            "Are you sure you want to delete " + selectedContact + "?",
            "Delete Contact",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (confirmDelete == javax.swing.JOptionPane.YES_OPTION) {
            boolean success = contactManager.deleteContact(username, selectedContact);

            if (success) {
                contactListModel.removeElement(selectedContact);  
                javax.swing.JOptionPane.showMessageDialog(
                    Contact.this,
                    "Contact deleted successfully.",
                    "Success",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    Contact.this,
                    "Failed to delete the contact.",
                    "Delete Failed",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(
            Contact.this,
            "Please select a contact to delete.",
            "No Contact Selected",
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
    }

    }//GEN-LAST:event_jButtonDelContactActionPerformed

    private void jButtonAddContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddContactActionPerformed
    String newContactUsername = javax.swing.JOptionPane.showInputDialog(
        Contact.this, 
        "Enter the username of the new contact:", 
        "Add New Contact", 
        javax.swing.JOptionPane.PLAIN_MESSAGE
    );

    if (newContactUsername != null && !newContactUsername.isEmpty()) {
        contactManager.addContact(this, username, newContactUsername); 
        loadContacts();
    } else {
        javax.swing.JOptionPane.showMessageDialog(
            Contact.this, 
            "Please enter a valid username for the new contact.", 
            "Invalid Input", 
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
    }

    }//GEN-LAST:event_jButtonAddContactActionPerformed

    private void jButtonEditContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditContactActionPerformed
    String selectedContact = jList1.getSelectedValue();  

    if (selectedContact != null) {
        String newContactUsername = javax.swing.JOptionPane.showInputDialog(
            Contact.this,
            "Enter the new username for the contact:",
            selectedContact
        );

        if (newContactUsername != null && !newContactUsername.isEmpty()) {
            boolean success = contactManager.editContact(username, selectedContact, newContactUsername);

            if (success) {
                int index = contactListModel.indexOf(selectedContact);
                contactListModel.set(index, newContactUsername);
                javax.swing.JOptionPane.showMessageDialog(
                    Contact.this,
                    "Contact edited successfully.",
                    "Success",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    Contact.this,
                    "Failed to edit the contact.",
                    "Edit Failed",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(
            Contact.this,
            "Please select a contact to edit.",
            "No Contact Selected",
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
    }    
    }//GEN-LAST:event_jButtonEditContactActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        String selectedContact = jList1.getSelectedValue();
        if (selectedContact != null && !selectedContact.isEmpty()) {
            System.out.println("Selected contact: " + selectedContact);  
        } else {
            System.out.println("No contact selected");  
        }
    
    }//GEN-LAST:event_jList1ValueChanged
private void openUserChatWindow(String username, String recipient) {
    ChatWindow chatWindow = new ChatWindow("Chat with " + recipient, -1); 
    chatWindow.setUsername(username);
    chatWindow.setRecipientType("User");
    chatWindow.setRecipient(recipient);

    chatWindow.setVisible(true);
    chatWindow.loadUserChatHistory();
}

    private void jButtonOpenchatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOpenchatMouseClicked
    String selectedContact = jList1.getSelectedValue();
    System.out.println("Selected contact: " + selectedContact);  

    if (selectedContact != null && !selectedContact.isEmpty()) {
        openUserChatWindow(username, selectedContact);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a contact to open a chat.", "No Contact Selected", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButtonOpenchatMouseClicked

    private void jButtonOpenchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOpenchatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            setVisible (false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddContact;
    private javax.swing.JButton jButtonDelContact;
    private javax.swing.JButton jButtonEditContact;
    private javax.swing.JButton jButtonOpenchat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
