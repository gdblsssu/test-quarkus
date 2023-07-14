package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "person")
public class Person extends PanacheEntityBase {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "surname")
    public String surname;

    @Column(name = "age")
    public Integer age;

    @Column(name = "phone")
    public String phone;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<OwnersDocument> ownersDocuments;

    public void addOwnersDocument(OwnersDocument ownersDocument) {
        ownersDocument.person = this;
        this.ownersDocuments.add(ownersDocument);
    }
}
