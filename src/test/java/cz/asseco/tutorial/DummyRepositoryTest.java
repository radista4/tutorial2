package cz.asseco.tutorial;

import cz.asseco.tutorial.entity.Dummy;
import cz.asseco.tutorial.repository.DummyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DummyRepositoryTest {

    @Autowired
    private DummyRepository dummyRepository;

    @Test
    void testSaveAndFindUser() {
        // Vytvoření nového uživatele
        Dummy dummy = new Dummy();
        dummy.setData("DataTesting");

        // Uložení do databáze
        dummyRepository.save(dummy);

        // Načtení uživatele z databáze
        Dummy foundUser = dummyRepository.findDummyByData("DataTesting");

        // Ověření, že uživatel je správně uložen
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getData()).isEqualTo("DataTesting");
    }
}
