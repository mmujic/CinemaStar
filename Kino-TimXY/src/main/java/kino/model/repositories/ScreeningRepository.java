package kino.model.repositories;

import kino.model.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Integer>{
}
