package com.github.echat;

import java.util.HashSet;
import java.util.Set;

/**
 * @author db1995
 */
public class EchatSingleton {
    private static EchatSingleton echatInstance = new EchatSingleton();
    private Set<ChatRoom> chatRoomSet = new HashSet<>();

    public static EchatSingleton getInstance() {
        return echatInstance;
    }

    private EchatSingleton() {
    }

    public Set<ChatRoom> getChatRoomSet() {
        return chatRoomSet;
    }
}
