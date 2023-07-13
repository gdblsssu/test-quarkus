package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CAR")
public class Car extends PanacheEntityBase {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Car_SEQ")
    @SequenceGenerator(name = "Car_SEQ", sequenceName = "Car_SEQ", allocationSize = 10)
    public Long id;

    @Column(name = "NAME")
    public String name;

    @Column(name = "COLOR")
    public String color;

    @Column(name = "MAX_SPEED")
    public Integer maxSpeed;

}
