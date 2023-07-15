package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.entity.Car;
import org.acme.entity.Person;
import org.acme.entity.VehicleType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OwnersDocumentDTO {
    @Schema(title = "Owners document id", required = true)
    public Long id;
    @Schema(title = "Car for which the document was created", required = true)
    public CarDTO carDTO;
    @Schema(title = "Owners document id", required = true)
    public PersonDTO personDTO;
    @Schema(title = "Vehicle type", required = true)
    public VehicleTypeDTO vehicleTypeDTO;
    @Schema(title = "The person who owns the car", required = true)
    public String note;

}
