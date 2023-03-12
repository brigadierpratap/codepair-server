package com.example.codepair.model;

import lombok.Data;

@Data
public class Message {
    private String sendToTopic;
    private String message;
    private String language;

}
