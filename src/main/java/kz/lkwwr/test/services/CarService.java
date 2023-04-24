package kz.lkwwr.test.services;

import kz.lkwwr.test.entities.Cars;
import kz.lkwwr.test.entities.Countries;
import kz.lkwwr.test.entities.Transmissions;

import java.util.List;

public interface CarService {
    Cars addCar(Cars car);
    List<Cars> getAllCars();
    Cars getCar(Long id);
    void deleteItem(Cars car);
    Cars saveCar(Cars car);
    List<Cars> getAllCarsByName(String name);
    List<Transmissions> getAllTransmissions();
    Transmissions addTransmission(Transmissions transmission);
    Transmissions saveTransmission(Transmissions transmission);
    Transmissions getTransmission(Long id);
    void deleteTransmission(Transmissions transmission);
    List<Countries> getAllCountries();
    Countries addCountry(Countries country);
    Countries saveCountry(Countries country);
    Countries getCountry(Long id);
    void deleteCountry(Countries country);

}
