package br.com.car_rental.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "brand")
public class BrandModel {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "brandModel")
    private List<CarModel> carModelList;
}
