package cz.asseco.tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "POBOCKA")
@Data
public class Pobocka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ADRESA")
    private String adresa;

    @Column(name = "POCET_TERMINALU")
    private int pocetTerminalu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIRMA_ID", nullable = false)
    private Firma firma;

    @OneToMany(mappedBy = "pobocka", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Terminal> terminaly = new ArrayList<>();
}

