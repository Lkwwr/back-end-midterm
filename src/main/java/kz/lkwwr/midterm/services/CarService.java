package kz.lkwwr.midterm.services;

import kz.lkwwr.midterm.entities.Car;
import kz.lkwwr.midterm.entities.Country;
import kz.lkwwr.midterm.entities.Transmission;

import java.util.List;

public interface CarService {
    Car addCar(Car car);

    List<Car> getAllCars();

    Car getCar(Long id);

    void deleteItem(Car car);

    Car saveCar(Car car);

    List<Car> getAllCarsByName(String name);

    List<Transmission> getAllTransmissions();

    Transmission addTransmission(Transmission transmission);

    Transmission saveTransmission(Transmission transmission);

    Transmission getTransmission(Long id);

    void deleteTransmission(Transmission transmission);

    List<Country> getAllCountries();

    Country addCountry(Country country);

    Country saveCountry(Country country);

    Country getCountry(Long id);

    void deleteCountry(Country country);

}
