package cz.asseco.tutorial.repository;

import cz.asseco.tutorial.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository extends JpaRepository<Dummy, Long> {
    Dummy findDummyByData(String dataTesting);
}
