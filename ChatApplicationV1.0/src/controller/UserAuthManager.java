package controller;
import dao.UserDAO;
import model.User;

public class UserAuthManager {
    private static UserAuthManager instance;
    private UserDAO userDAO;

    private UserAuthManager() {
        this.userDAO = new UserDAO();
    }

    public static UserAuthManager getInstance() {
        if (instance == null) {
            instance = new UserAuthManager();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        return userDAO.login(username, password);
    }

    public String signUp(String username, String email, String passwordHash, String profilePicture, String status) {
        return userDAO.signUp(username, email, passwordHash, profilePicture, status);
    }

}