package org.pfe.constat.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class DescriptionDeVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String direction;
    private String matricule;
    @OneToOne
    private InformationDeVehicule informationDeVehicule;
}
