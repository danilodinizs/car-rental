package br.com.car_rental.repositories;

import br.com.car_rental.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarModel, UUID> {

    public List<CarModel> findByName(String name);

    @Query("SELECT c FROM CarModel c WHERE c.year > :year")
    public List<CarModel> findAboveYear(int year);
}
