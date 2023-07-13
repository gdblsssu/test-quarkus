package org.acme.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.entity.OwnersDocument;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    @Schema(title = "Person id", required = true)
    Long id;
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
    public Set<OwnersDocument> ownersDocuments;

}
