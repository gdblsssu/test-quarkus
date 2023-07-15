package org.acme.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {

    @Schema(title = "Person id", required = true)
    public Long id;
    @NotBlank
    @Schema(title = "Person name", required = true)
    public String name;
    @NotBlank
    @Schema(title = "Person surname", required = true)
    public String surname;
    @Min(value = 18, message = "The value must be more than 17")
    @Max(value = 110, message = "The value must be less than 111")
    @Schema(title = "Person age between 18 to 110", required = true)
    public Integer age;
    @NotBlank
    @Schema(title = "Person phone", required = true)
    public String phone;
    @Schema(title = "Cars", required = false)
    public Set<CarDTO> carDTOSet;

}
