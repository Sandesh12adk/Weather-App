package com.example.minor.project.controller;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.service.WeatherRedisService;
import com.example.minor.project.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @Autowired
    private  SimpMessagingTemplate messagingTemplate;
    @Autowired
    private WeatherRedisService weatherRedisService;
    Logger logger= LoggerFactory.getLogger(WebSocketController.class);
    @MessageMapping("/chat.send")
    public void sendMessage(@Payload RequestWeatherData requestWeatherData){
        messagingTemplate.convertAndSend("/topic",requestWeatherData);
        weatherRedisService.save(requestWeatherData);
        logger.info("****************  "+ requestWeatherData.toString());
    }
}
