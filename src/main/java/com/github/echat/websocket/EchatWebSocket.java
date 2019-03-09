package com.github.echat.websocket;

import com.github.echat.entity.User;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

//@ServerEndpoint("/websocket/{user}")
@ServerEndpoint("/websocket")
@Component
public class EchatWebSocket {
    public static List<String> usernameList = new ArrayList<>();
    public static List<String> sessionIdList = new ArrayList<>();

    /**
     * Record the number of online people
     */
    private static int onlineCount = 0;
    /**
     * Store WebSocket instance
     */
    private static CopyOnWriteArraySet<EchatWebSocket> webSocketSet = new CopyOnWriteArraySet<EchatWebSocket>();

    private Session session;
    private String nickname;

    /**
     * Send message to all
     *
     * @param message
     */
    public static void sendToAll(String message) {
        for (EchatWebSocket item : webSocketSet) {
            try {
                item.sendToOne(message, null);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        EchatWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        EchatWebSocket.onlineCount--;
    }

    /**
     * Send message to one
     *
     * @param message
     * @param session
     * @throws IOException
     */
    public void sendToOne(String message, Session session) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * Confirm sessionId and color after connecting
     */
    @OnOpen
    public synchronized void onOpen(Session session) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        sessionIdList.add(session.getId());
        this.nickname = usernameList.get(sessionIdList.indexOf(session.getId()));
        onMessage("[" + nickname + "] come in<br>" +
                "Current online: " + onlineCount + "&s1&" + session.getId() + "&"
                + nickname + "&" + User.color, session);
        User.map.put(session.getId(), User.color);
        User.color++;
    }

    /**
     * Invoke when connection closed
     */
    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(this);
        subOnlineCount();
        onMessage("[" + usernameList.get(sessionIdList.indexOf(session.getId())) + "] left<br>" +
                "Current online: " + onlineCount + "&s0", session);
        usernameList.remove(sessionIdList.indexOf(session.getId()));
        sessionIdList.remove(session.getId());
    }

    /**
     * Invoke when receive message
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        //群发消息
        for (EchatWebSocket item : webSocketSet) {
            try {
                item.sendToOne(message + "&s2&" + session.getId() + "&"
                        + this.nickname + "&" + User.map.get(session.getId()), session);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
