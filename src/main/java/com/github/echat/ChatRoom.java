package com.github.echat;

import javax.websocket.Session;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author db1995
 */
public class ChatRoom implements Observable {
    private CopyOnWriteArraySet<Observer> observerSet = new CopyOnWriteArraySet<>();
    private HashMap<String, Chatter> chatterMap = new HashMap<>();

    private static int ONLINE_CHATTER_COUNT = 0;

    @Override
    public void attachObserver(Observer observer) {
        observerSet.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {

    }

    @Override
    public void notifyAllObservers(Object object) {
        chatterMap.forEach((k, v) -> {
            try {
                v.getSession().getBasicRemote().sendText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public HashMap<String, Chatter> getChatterMap() {
        return chatterMap;
    }

    public synchronized int getOnlineChatterCount() {
        return ChatRoom.ONLINE_CHATTER_COUNT;
    }

    public synchronized void addOnlineChatterCount() {
        ChatRoom.ONLINE_CHATTER_COUNT++;
    }

    public synchronized void subOnlineChatterCount() {
        ChatRoom.ONLINE_CHATTER_COUNT--;
    }
}
