package com.github.echat;

import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author db1995
 */
@Component
@ServerEndpoint("/chat")
public class EchatWebSocket {
    @OnOpen
    public synchronized void onOpen(Session session) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Chatter chatter = new Chatter();
        chatter.attachObserver(chatter);
    }
}
