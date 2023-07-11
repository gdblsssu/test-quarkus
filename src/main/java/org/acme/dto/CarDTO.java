package org.acme.dto;

import jakarta.persistence.Column;

public class CarDTO {
    public Long id;
    public String name;
    public String color;
    public Integer maxSpeed;

    public CarDTO(Long id, String name, String color, Integer maxSpeed) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
