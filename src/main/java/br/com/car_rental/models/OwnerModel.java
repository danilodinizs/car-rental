package br.com.car_rental.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "owner")
public class OwnerModel {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int age;
}
