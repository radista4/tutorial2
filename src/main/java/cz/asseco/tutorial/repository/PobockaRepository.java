package cz.asseco.tutorial.repository;

import cz.asseco.tutorial.entity.Pobocka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PobockaRepository extends JpaRepository<Pobocka, Long> {
}
