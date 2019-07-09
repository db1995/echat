package com.github.echat.controller;

import com.github.echat.Chatter;
import com.github.echat.entity.User;
import com.github.echat.websocket.EchatWebSocket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dispatcher
 *
 * @author db1995
 */
@RestController
public class EchatController1 {
    /**
     * Receive user's information
     *
     * @param chatter
     */
    @PostMapping("/user")
    public String register(@RequestBody Chatter chatter) {
        //Not allow existed username
        return "";
    }
}
