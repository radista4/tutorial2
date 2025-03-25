package cz.asseco.tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity (name = "FIRMA")
@Data
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ICO")
    private String ico;

    @Column(name = "ADRESA_SIDLA")
    private String adresaSidla;

    @Column(name = "NAZEV_FIRMY")
    private String nazevFirmy;

    @Column(name = "POBOCKY")
    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL)
    private List<Pobocka> pobocky;
}

