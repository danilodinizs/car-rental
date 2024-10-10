package br.com.car_rental.models;

import jakarta.persistence.*;
import lombok.Data;

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
}
