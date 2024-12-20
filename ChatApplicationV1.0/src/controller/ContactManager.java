package controller;

import dao.ContactDAO;
import view.Contact;
import java.util.List;

public class ContactManager {
    private ContactDAO contactDAO;

    public ContactManager() {
        this.contactDAO = new ContactDAO();
    }

    public List<String> getUserContacts(String username) {
        return contactDAO.getUserContacts(username);
    }

    public void addContact(Contact contactWindow, String username, String contactUsername) {
        if (contactDAO.addContact(username, contactUsername)) {
            javax.swing.JOptionPane.showMessageDialog(
                contactWindow, 
                "Contact added successfully.", 
                "Success", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                contactWindow, 
                "An error occurred while adding the contact.", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public boolean deleteContact(String username, String contactUsername) {
        return contactDAO.deleteContact(username, contactUsername);
    }

    public boolean editContact(String username, String oldContactUsername, String newContactUsername) {
        return contactDAO.editContact(username, oldContactUsername, newContactUsername);
    }
}