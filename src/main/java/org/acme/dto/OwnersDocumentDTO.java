package org.acme.dto;

import org.acme.entity.Car;
import org.acme.entity.Person;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class OwnersDocumentDTO {
    @Schema(title = "Owners document id", required = true)
    public Long id;
    @Schema(title = "Car for which the document was created", required = true)
    public Car car;
    @Schema(title = "The person who owns the car", required = true)
    public String note;
    @Schema(title = "Owners document id", required = true)
    public Person person;

    public OwnersDocumentDTO(Long id, Car car, String note, Person person) {
        this.id = id;
        this.car = car;
        this.note = note;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
