package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class CarController {
     List<Car> cars = new ArrayList<Car>();


    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        // Simuler la récupération de la liste des voitures
        cars.add(new Car("ABC123", "Ferrari", 100));
        cars.add(new Car("XYZ789", "Lamborghini", 200));
        return cars;
    }



    @GetMapping("/cars/{plateNumber}")
    public ResponseEntity<Car> getCarFeatures(@PathVariable String plateNumber) {
        Car car = new Car();
        car.setPlateNumber(plateNumber);
        car.setBrand("Ferrari");
  car.setPrice(100);

        return ResponseEntity.ok(car);
    }

    @PutMapping("/cars/{plateNumber}")
    public ResponseEntity<String> rentCar(@PathVariable String plateNumber, @RequestParam boolean rent, @RequestBody RentRequest rentRequest) {
        // Simuler la location de la voiture
        if (rent) {
            return ResponseEntity.ok("Car rented successfully from " + rentRequest.getBegin() + " to " + rentRequest.getEnd());
        } else {
            return ResponseEntity.badRequest().body("Invalid request");
        }
    }

    @PutMapping("/cars/{plateNumber}/return")
    public ResponseEntity<String> returnCar(@PathVariable String plateNumber, @RequestParam boolean rent) {
        // Simuler le retour de la voiture
        if (!rent) {
            return ResponseEntity.ok("Car returned successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid request");
        }
    }
}
