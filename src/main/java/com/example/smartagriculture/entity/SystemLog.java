package com.example.smartagriculture.entity;

import java.time.LocalDateTime;

public class SystemLog {
    private Integer log_id;
    private String log_type;
    private String action;
    private Integer success;
    private String details;
    private LocalDateTime log_time;

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public String getLog_type() {
        return log_type;
    }

    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer isSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getLog_time() {
        return log_time;
    }

    public void setLog_time(LocalDateTime log_time) {
        this.log_time = log_time;
    }
}
