package kz.lkwwr.test.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.test.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CarsRepository extends JpaRepository<Cars, Long> {

    List<Cars> findAllByName(String name);

}
