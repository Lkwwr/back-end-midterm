package kz.lkwwr.midterm.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.midterm.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByName(String name);
}
