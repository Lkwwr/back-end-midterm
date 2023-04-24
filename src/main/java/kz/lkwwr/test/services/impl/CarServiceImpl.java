package kz.lkwwr.test.services.impl;

import kz.lkwwr.test.entities.Car;
import kz.lkwwr.test.entities.Country;
import kz.lkwwr.test.entities.Transmission;
import kz.lkwwr.test.repositories.CarRepository;
import kz.lkwwr.test.repositories.CountryRepository;
import kz.lkwwr.test.repositories.TransmissionRepository;
import kz.lkwwr.test.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TransmissionRepository transmissionRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Car> getAllCarsByName(String name) {
        return carRepository.findAllByName(name);
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(Long id) {
        return carRepository.getReferenceById(id);
    }

    @Override
    public void deleteItem(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Transmission> getAllTransmissions() {
        return transmissionRepository.findAll();
    }

    @Override
    public Transmission addTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public Transmission saveTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public Transmission getTransmission(Long id) {
        return transmissionRepository.getReferenceById(id);
    }

    @Override
    public void deleteTransmission(Transmission transmission) {
        transmissionRepository.delete(transmission);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.getReferenceById(id);
    }

    @Override
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }
}
