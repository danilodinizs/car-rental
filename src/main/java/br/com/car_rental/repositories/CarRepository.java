package br.com.car_rental.repositories;

import br.com.car_rental.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<CarModel, UUID> {
}
