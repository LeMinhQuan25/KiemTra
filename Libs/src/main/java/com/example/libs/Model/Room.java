package com.example.libs.Model;

import java.io.Serializable;
import java.util.UUID;

public class Room implements Serializable {
    UUID id;
    String name;
    String code;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
