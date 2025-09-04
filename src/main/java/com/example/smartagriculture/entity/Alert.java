package com.example.smartagriculture.entity;

import java.time.LocalDateTime;

public class Alert {
    private Integer alert_id;
    private String alert_type;
    private String source_type;
    private Integer source_id;
    private String alert_message;
    private LocalDateTime alert_time;
    private String status;

    public Integer getAlert_id() {
        return alert_id;
    }

    public void setAlert_id(Integer alert_id) {
        this.alert_id = alert_id;
    }

    public String getAlert_type() {
        return alert_type;
    }

    public void setAlert_type(String alert_type) {
        this.alert_type = alert_type;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public Integer getSource_id() {
        return source_id;
    }

    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
    }

    public String getAlert_message() {
        return alert_message;
    }

    public void setAlert_message(String alert_message) {
        this.alert_message = alert_message;
    }

    public LocalDateTime getAlert_time() {
        return alert_time;
    }

    public void setAlert_time(LocalDateTime alert_time) {
        this.alert_time = alert_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
