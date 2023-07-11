package org.acme.dto;

import org.acme.entity.Car;
import org.acme.entity.Person;

public class OwnersDocumentDTO {
    public Long id;
    public Car car;
    public String note;
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
