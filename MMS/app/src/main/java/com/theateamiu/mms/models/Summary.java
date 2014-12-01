package com.theateamiu.mms.models;

import java.io.Serializable;

public class Summary implements Serializable{
    private String key;
    private String value;
    private long managerialId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getManagerialId() {
        return managerialId;
    }

    public void setManagerialId(long managerialId) {
        this.managerialId = managerialId;
    }
}
