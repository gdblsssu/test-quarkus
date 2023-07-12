package org.acme.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class CarDTO {
    @Schema(title = "Car id", required = true)
    public Long id;
    @NotBlank
    @Schema(title = "Car name", required = true)
    public String name;
    @NotBlank
    @Schema(title = "Car color", required = true)
    public String color;
    @Min(value = 10, message = "The value must be more than 9")
    @Max(value = 400, message = "The value must be less than 401")
    @Schema(title = "Car max speed between 10 to 400", required = true)
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
