package com.github.echat;

import javax.websocket.Session;

/**
 * @author db1995
 */
public class Chatter implements Observer {
    private Session session;
    private String nickName;

    public Chatter(Session session) {
        this.session = session;
    }

    @Override
    public void update() {

    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
