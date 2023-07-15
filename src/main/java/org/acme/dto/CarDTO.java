package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    @Schema(title = "Owners document id", required = true)
    @JsonIgnore
    public PersonDTO personDTO;
    @Schema(title = "Vehicle type", required = true)
    public VehicleTypeDTO vehicleTypeDTO;


}
