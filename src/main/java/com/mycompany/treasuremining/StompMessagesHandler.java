/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treasuremining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.mycompany.treasuremining.model.Player;

/**
 *
 * @author Miguel Rojas
 */
@Controller
public class StompMessagesHandler {
    
    @Autowired
    public SimpMessagingTemplate msgt;
    
    @MessageMapping("/registerPlayer")
    public void handleRegisterPlayer(Player player) {
        System.out.println("New Player Received = " + player.getPlayerId() + " " + player.getPlayerX() + " " + player.getPlayerY());
        msgt.convertAndSend("/client/newPlayer", player);
    }
    
    @MessageMapping("/updatePlayer")
    public void handleUpdatePlayer(Player player) {
        msgt.convertAndSend("/client/playerUpdate", player);
    }
    
}
