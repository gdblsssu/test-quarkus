package org.acme.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CarDTO {
    public Long id;
    @NotBlank
    public String name;
    @NotBlank
    public String color;
    @Min(10)
    @Max(400)
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
