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
@AllArgsConstructor
@NoArgsConstructor
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

    public void addOwnersDocument(OwnersDocument ownersDocument) {
        ownersDocument.person = this;
        this.ownersDocuments.add(ownersDocument);
    }
}
