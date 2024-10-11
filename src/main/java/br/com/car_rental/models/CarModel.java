package br.com.car_rental.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "car")
public class CarModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int year;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrandModel brandModel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owner_car")
    private List<OwnerModel> ownerModelList;
}
