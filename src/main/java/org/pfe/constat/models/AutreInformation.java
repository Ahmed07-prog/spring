package org.pfe.constat.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class AutreInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String point_choc_initial;
    private String degat_apparents;
    private String observation;
    private String croquis;
    private String signature;
    @OneToOne
    private InformationDeVehicule informationDeVehicule;

}
