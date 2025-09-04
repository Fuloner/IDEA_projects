package com.example.smartagriculture.entity;

import java.time.LocalDateTime;

public class ChatMessage {
    private Integer message_id;
    private Integer user_id;
    private String content;
    private String response;
    private LocalDateTime timestamp;
    private Integer tokens;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTokens() {
        return tokens;
    }

    public void setTokens(Integer tokens) {
        this.tokens = tokens;
    }
}
