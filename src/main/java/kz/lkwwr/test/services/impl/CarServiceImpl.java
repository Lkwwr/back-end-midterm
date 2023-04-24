package kz.lkwwr.test.services.impl;

import kz.lkwwr.test.entities.Cars;
import kz.lkwwr.test.entities.Countries;
import kz.lkwwr.test.entities.Transmissions;
import kz.lkwwr.test.repositories.CarsRepository;
import kz.lkwwr.test.repositories.CountriesRepository;
import kz.lkwwr.test.repositories.TransmissionsRepository;
import kz.lkwwr.test.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarsRepository carsRepository;
    @Autowired
    private TransmissionsRepository transmissionsRepository;
    @Autowired
    private CountriesRepository countriesRepository;

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

    @Override
    public List<Transmissions> getAllTransmissions() {
        return transmissionsRepository.findAll();
    }

    @Override
    public Transmissions addTransmission(Transmissions transmission) {
        return transmissionsRepository.save(transmission);
    }

    @Override
    public Transmissions saveTransmission(Transmissions transmission) {
        return transmissionsRepository.save(transmission);
    }

    @Override
    public Transmissions getTransmission(Long id) {
        return transmissionsRepository.getReferenceById(id);
    }

    @Override
    public void deleteTransmission(Transmissions transmission) {
        transmissionsRepository.delete(transmission);
    }

    @Override
    public List<Countries> getAllCountries() {
        return countriesRepository.findAll();
    }

    @Override
    public Countries addCountry(Countries country) {
        return countriesRepository.save(country);
    }

    @Override
    public Countries saveCountry(Countries country) {
        return countriesRepository.save(country);
    }

    @Override
    public Countries getCountry(Long id) {
        return countriesRepository.getReferenceById(id);
    }

    @Override
    public void deleteCountry(Countries country) {
        countriesRepository.delete(country);
    }
}
