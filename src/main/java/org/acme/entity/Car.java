package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "car")
public class Car extends PanacheEntityBase {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "color")
    public String color;

    @Column(name = "max_speed")
    public Integer maxSpeed;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "person")
    @JsonIgnore
    public Person person;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "vehicle_type")
    public VehicleType vehicleType;

}
