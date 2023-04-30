package kz.lkwwr.midterm.repositories;

import kz.lkwwr.midterm.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
