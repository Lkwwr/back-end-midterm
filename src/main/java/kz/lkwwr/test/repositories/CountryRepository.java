package kz.lkwwr.test.repositories;

import kz.lkwwr.test.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
