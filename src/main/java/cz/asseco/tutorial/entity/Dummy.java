package cz.asseco.tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DUMMY")
public class Dummy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATA")
    private String data;
}