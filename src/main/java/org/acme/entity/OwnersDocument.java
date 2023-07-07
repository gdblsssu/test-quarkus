package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "OWNERSDOCUMENT")
public class OwnersDocument extends PanacheEntityBase {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OWNERSDOCUMENT_SEQ")
    @SequenceGenerator(name = "OWNERSDOCUMENT_SEQ", sequenceName = "OWNERSDOCUMENT_SEQ", allocationSize = 10)
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "person")
    @JsonIgnore
    public Person person;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car")
    public Car car;

    @Column(name = "NOTE")
    public String note;


}
