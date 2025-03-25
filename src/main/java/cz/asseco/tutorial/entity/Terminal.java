package cz.asseco.tutorial.entity;

import cz.asseco.tutorial.enums.ModelEnum;
import cz.asseco.tutorial.enums.StavEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "TERMINAL")
@Data
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "KOD", nullable = false)
    private int kod;

    @Column(name = "POZNAMKA")
    private String poznamka;

    @Enumerated(EnumType.STRING)
    private ModelEnum model;

    @Enumerated(EnumType.STRING)
    private StavEnum stav;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POBOCKA_ID")
    private Pobocka pobocka;
}
