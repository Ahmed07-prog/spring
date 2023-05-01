package org.pfe.constat.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class SocieteAssurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_complet_assure;
    private int numero_contrat;
    private String nom_agence;
    private Date validite_attestaion;
    @OneToOne
    private InformationDeVehicule informationDeVehicule;
}
