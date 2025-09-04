package com.example.smartagriculture.entity;

import java.time.LocalDateTime;

public class Area {
    private Integer area_id;
    private Integer user_id;
    private String areaname;
    private String address;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
