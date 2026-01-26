package com.example.minor.project.controller;

import com.example.minor.project.dto.RequestWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @Autowired
    private  SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/chat.send")
    public void sendMessage(@Payload RequestWeatherData requestWeatherData){
        messagingTemplate.convertAndSend("/topic",requestWeatherData);
    }

}
