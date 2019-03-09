package com.github.echat.controller;

import com.github.echat.entity.User;
import com.github.echat.websocket.EchatWebSocket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author db1995
 */
@RestController
public class EchatController {
    /**
     * Receive user's information
     *
     * @param user
     */
    @PostMapping("/user")
    public void socket(@RequestBody User user) {
        EchatWebSocket.usernameList.add(user.getNickname());
    }
}
