package kz.lkwwr.test.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.test.entities.Transmissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TransmissionsRepository extends JpaRepository<Transmissions, Long> {
}
