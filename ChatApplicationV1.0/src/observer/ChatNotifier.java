
package observer;
import observer.ChatObserver;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author fadyw
 */

public class ChatNotifier implements ChatSubject {
    private List<ChatObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(ChatObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ChatObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (ChatObserver observer : observers) {
            observer.update(message);
        }
    }
}
