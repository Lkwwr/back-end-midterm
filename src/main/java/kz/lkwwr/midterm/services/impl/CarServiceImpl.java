package kz.lkwwr.midterm.services.impl;

import kz.lkwwr.midterm.entities.Car;
import kz.lkwwr.midterm.entities.Country;
import kz.lkwwr.midterm.entities.Type;
import kz.lkwwr.midterm.repositories.CarRepository;
import kz.lkwwr.midterm.repositories.CountryRepository;
import kz.lkwwr.midterm.repositories.TypeRepository;
import kz.lkwwr.midterm.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private CountryRepository countryRepository;

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
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
    @Override
    public Type getType(Long id) {
        return typeRepository.getReferenceById(id);
    }
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    @Override
    public Country getCountry(Long id) {
        return countryRepository.getReferenceById(id);
    }
}
