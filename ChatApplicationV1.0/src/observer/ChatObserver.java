
package observer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public interface ChatObserver {
    void update(String message);
}
