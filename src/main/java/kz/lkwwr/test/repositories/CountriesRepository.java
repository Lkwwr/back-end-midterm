package kz.lkwwr.test.repositories;

import kz.lkwwr.test.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, Long> {
}
