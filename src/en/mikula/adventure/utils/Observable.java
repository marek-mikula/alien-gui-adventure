package en.mikula.adventure.utils;

import java.util.HashSet;
import java.util.Set;

public class Observable {

    private final Set<Observer> observers = new HashSet<>();

    /**
     * Registers an observer
     */
    public boolean registerObserver(Observer observer) {
        return this.observers.add(observer);
    }

    /**
     * Unregisters an observer
     */
    public boolean unregisterObserver(Observer observer) {
        return this.observers.remove(observer);
    }

    /**
     * Notifies all observers that a change has been done
     */
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

}
