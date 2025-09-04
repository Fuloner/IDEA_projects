package com.example.smartagriculture.entity;

import java.time.LocalDateTime;

public class SystemSetting {
    private Integer setting_id;
    private String setting_key;
    private String setting_value;
    private String description;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

    public Integer getSetting_id() {
        return setting_id;
    }

    public void setSetting_id(Integer setting_id) {
        this.setting_id = setting_id;
    }

    public String getSetting_key() {
        return setting_key;
    }

    public void setSetting_key(String setting_key) {
        this.setting_key = setting_key;
    }

    public String getSetting_value() {
        return setting_value;
    }

    public void setSetting_value(String setting_value) {
        this.setting_value = setting_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }
}
