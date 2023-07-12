package org.acme.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.acme.entity.OwnersDocument;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.HashSet;
import java.util.Set;

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
    public Set<OwnersDocument> ownersDocuments = new HashSet<>();
    public PersonDTO(Long id, String name, String surname, Integer age, String phone, Set<OwnersDocument> ownersDocuments) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.ownersDocuments = ownersDocuments;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<OwnersDocument> getOwnersDocuments() {
        return ownersDocuments;
    }

    public void setOwnersDocuments(Set<OwnersDocument> ownersDocuments) {
        this.ownersDocuments = ownersDocuments;
    }
}
