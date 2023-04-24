package kz.lkwwr.test.services.impl;

import kz.lkwwr.test.entities.Cars;
import kz.lkwwr.test.repositories.CarsRepository;
import kz.lkwwr.test.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public List<Cars> getAllCarsByName(String name) {
        return carsRepository.findAllByName(name);
    }

    @Override
    public Cars addCar(Cars car) {
        return carsRepository.save(car);
    }

    @Override
    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }

    @Override
    public Cars getCar(Long id) {
        return carsRepository.getReferenceById(id);
    }

    @Override
    public void deleteItem(Cars car) {
        carsRepository.delete(car);
    }

    @Override
    public Cars saveCar(Cars car) {
        return carsRepository.save(car);
    }
}
