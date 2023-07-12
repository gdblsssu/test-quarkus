package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Person")
public class Person extends PanacheEntityBase {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Person_SEQ")
    @SequenceGenerator(name = "Person_SEQ", sequenceName = "Person_SEQ", allocationSize = 10)
    public Long id;

    @Column(name = "NAME")
    public String name;

    @Column(name = "SURNAME")
    public String surname;

    @Column(name = "AGE")
    public Integer age;

    @Column(name = "PHONE")
    public String phone;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<OwnersDocument> ownersDocuments;

    public void addOwnersDocument(OwnersDocument ownersDocument){
        ownersDocument.person = this;
        this.ownersDocuments.add(ownersDocument);
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
