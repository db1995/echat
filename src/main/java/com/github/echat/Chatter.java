package com.github.echat;

import com.github.echat.EchatSingleton;
import com.github.echat.Observable;
import com.github.echat.Observer;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author db1995
 */
public class Chatter implements Observable, Observer {
    private Session session;

    @Override
    public void attachObserver(Observer observer) {

    }

    @Override
    public void detachObserver(Observer observer) {

    }

    @Override
    public void notifyAllObservers() {

    }

    @Override
    public void update() {

    }
}
