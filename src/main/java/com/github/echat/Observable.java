package com.github.echat;

/**
 * @author db1995
 */
public interface Observable {
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
    void notifyAllObservers(Object object);
}
