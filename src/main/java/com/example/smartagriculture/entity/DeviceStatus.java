package com.example.smartagriculture.entity;

import java.time.LocalDateTime;

public class DeviceStatus {
    private Integer deviceId;
    private Integer level;
    private Integer autoMode;
    private Integer operationUser;
    private LocalDateTime operationTime;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAutoMode() {
        return autoMode;
    }

    public void setAutoMode(Integer autoMode) {
        this.autoMode = autoMode;
    }

    public Integer getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(Integer operationUser) {
        this.operationUser = operationUser;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }
}
