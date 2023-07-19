package org.acme.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class VehicleTypeDTO {
    @Schema(name = "Vehicle type id", required = true)
    public Long id;
    @Schema(name = "Vehicle type code", required = true)
    public Integer code;
    @Schema(name = "Vehicle type name", required = true)
    public String typeName;
}
