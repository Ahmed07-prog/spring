package org.pfe.constat.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Temoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_complet;
    private String adresse;
    private int num_tel;
    @OneToOne
    private Constat constat;
}
