package kz.lkwwr.midterm.services;

import kz.lkwwr.midterm.entities.Car;
import kz.lkwwr.midterm.entities.Country;
import kz.lkwwr.midterm.entities.Type;

import java.util.List;

public interface CarService {
    Car addCar(Car car);

    List<Car> getAllCars();

    Car getCar(Long id);

    void deleteCar(Car car);

    Car saveCar(Car car);

    List<Type> getAllTypes();

    Type getType(Long id);

    List<Country> getAllCountries();

    Country getCountry(Long id);
}
