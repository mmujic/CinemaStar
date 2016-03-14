package kino.model.repositories;

import kino.model.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ekusundzija on 3/14/16.
 */
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
