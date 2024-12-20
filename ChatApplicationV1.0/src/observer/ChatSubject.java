
package observer;


public interface ChatSubject {
    void addObserver(ChatObserver observer);
    void removeObserver(ChatObserver observer);
    void notifyObservers(String message);

}
