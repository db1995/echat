package com.github.echat;

import com.github.echat.entity.User;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;

/**
 * @author db1995
 */
@Component
@ServerEndpoint("/chat")
public class EchatWebSocket {
    private ChatRoom chatRoom = new ChatRoom();

    @OnOpen
    public synchronized void onOpen(Session session) {
        Chatter chatter = new Chatter(session);
        chatRoom.attachObserver(chatter);
        chatRoom.addOnlineChatterCount();
        chatRoom.getChatterMap().put(session.getId(), chatter);
    }

    public void sendToOne(String message, Session session) throws IOException {
        try {
            session.getBasicRemote().sendObject(message);
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void sendToAll(String message) {
        chatRoom.notifyAllObservers(message);
    }

    @OnClose
    public void onClose(Session session) {

    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
