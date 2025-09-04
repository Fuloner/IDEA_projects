package com.example.smartagriculture.entity;

import java.time.LocalDateTime;
import java.util.Map;

public class DeviceLog {
    private Long log_id;
    private Long device_id;
    private String operation_type;
    //private Map<String,Object> operation_params;
    private Integer operator_id;
    private String operator_type;
    private LocalDateTime operation_time;

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }
/*
    public Map<String, Object> getOperation_params() {
        return operation_params;
    }

    public void setOperation_params(Map<String, Object> operation_params) {
        this.operation_params = operation_params;
    }
*/
    public Integer getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(Integer operator_id) {
        this.operator_id = operator_id;
    }

    public String getOperator_type() {
        return operator_type;
    }

    public void setOperator_type(String operator_type) {
        this.operator_type = operator_type;
    }

    public LocalDateTime getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(LocalDateTime operation_time) {
        this.operation_time = operation_time;
    }
}
