package kz.lkwwr.midterm.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.midterm.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Long> {
}
