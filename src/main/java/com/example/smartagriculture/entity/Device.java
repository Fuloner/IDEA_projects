package com.example.smartagriculture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Device {
    private Integer device_id;
    private Integer area_id;
    private String device_name;
    private String device_category;
    private String device_type;
    private String device_description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_category() {
        return device_category;
    }

    public void setDevice_category(String device_category) {
        this.device_category = device_category;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_description() {
        return device_description;
    }

    public void setDevice_description(String device_description) {
        this.device_description = device_description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
