package kz.lkwwr.test.services;

import kz.lkwwr.test.entities.Cars;

import java.util.List;

public interface CarService {
    Cars addCar(Cars car);
    List<Cars> getAllCars();
    Cars getCar(Long id);
    void deleteItem(Cars car);
    Cars saveCar(Cars car);
    List<Cars> getAllCarsByName(String name);
}
