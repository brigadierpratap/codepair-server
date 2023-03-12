package com.example.codepair.controller;

import com.example.codepair.model.Message;
import com.example.codepair.model.Room;
import com.example.codepair.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MessageController {

    @Autowired private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired private RoomService roomService;
    @MessageMapping("/message")
    public Message receiveMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getSendToTopic(),"/receive",message);
        roomService.saveRoomAsync(
                Room.builder()
                        .code(message.getMessage())
                        .language(message.getLanguage())
                        .id(message.getSendToTopic())
                .build());
        return message;
    }
}
