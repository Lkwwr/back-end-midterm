package kz.lkwwr.test.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.test.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByName(String name);

}
