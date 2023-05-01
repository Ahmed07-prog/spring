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
public class IdentiteDuConducteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String permis;
    private Date date_delivration_permis;
    @OneToOne
    private InformationDeVehicule informationDeVehicule;
}
