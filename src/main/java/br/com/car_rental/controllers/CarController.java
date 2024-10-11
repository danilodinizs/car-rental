package br.com.car_rental.controllers;

import br.com.car_rental.models.CarModel;
import br.com.car_rental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody CarModel carModel) {
        try {
            String message = this.carService.save(carModel);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody CarModel  carModel,@PathVariable UUID id){
        try {
            String message = this.carService.update(carModel, id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (UUID id) {
        try {
            String message = this.carService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CarModel>> findAll() {
        try {
            List<CarModel> list = this.carService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarModel> findById(@PathVariable UUID id) {
        try {
            CarModel carModel = this.carService.findById(id);
            return new ResponseEntity<>(carModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<CarModel>> findByName(@RequestParam String name) {
        try {
            List<CarModel> listByName = this.carService.findByName(name);
            return new ResponseEntity<>(listByName, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/year")
    public ResponseEntity<List<CarModel>> findAboveYear(@RequestParam int year) {
        try {
            List<CarModel> listAboveYear = this.carService.findAboveYear(year);
            return new ResponseEntity<>(listAboveYear, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
