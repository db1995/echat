package com.github.echat;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author db1995
 */
public class ChatRoom implements Observable {
    public static CopyOnWriteArraySet<Chatter> observerSet = new CopyOnWriteArraySet<>();
    public static int ONLINE_CHATTER_COUNT = 0;

    @Override
    public void attachObserver(Observer observer) {

    }

    @Override
    public void detachObserver(Observer observer) {

    }

    @Override
    public void notifyAllObservers() {

    }

    public static synchronized int getOnlineChatterCount() {
        return ChatRoom.ONLINE_CHATTER_COUNT;
    }

    public static synchronized void addOnlineChatterCount() {
        ChatRoom.ONLINE_CHATTER_COUNT++;
    }

    public static synchronized void subOnlineChatterCount() {
        ChatRoom.ONLINE_CHATTER_COUNT--;
    }
}
