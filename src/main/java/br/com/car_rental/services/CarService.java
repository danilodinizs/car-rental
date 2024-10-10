package br.com.car_rental.services;

import br.com.car_rental.models.CarModel;
import br.com.car_rental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public String save(CarModel carModel) {
        this.carRepository.save(carModel);
        return "Car saved successfully";
    }

    public String update(CarModel  carModel, UUID id){
        carModel.setId(id);
        this.carRepository.save(carModel);
        return "Car updated successfully";
    }

    public String delete(UUID id) {
        this.carRepository.deleteById(id);
        return "Car deleted successfully";
    }

    public List<CarModel> findAll() {
        List<CarModel> list = this.carRepository.findAll();
        return list;
    }

    public CarModel findById(UUID id) {
        CarModel carModel = this.carRepository.findById(id).get();
        return carModel;
    }
}
