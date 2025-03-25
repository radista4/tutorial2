package cz.asseco.tutorial.repository;

import cz.asseco.tutorial.entity.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, Long> {
}
