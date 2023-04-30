package kz.lkwwr.midterm.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.midterm.entities.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
}
