package com.github.echat.entity;

import java.util.HashMap;

/**
 * @author db1995
 */
public class User {
    /**
     * key: sessionId
     * value: color
     */
    public static HashMap<String, String> map = new HashMap<>();
    private String nickname;
    private String sessionId;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
