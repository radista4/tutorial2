package cz.asseco.tutorial.repository;

import cz.asseco.tutorial.entity.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, Long> {
    List<Firma> findFirmaByIco(String ico);
    List<Firma> findFirmaByNazevFirmy(String nazevFirmy);
}