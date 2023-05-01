package org.pfe.constat.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class InformationDeVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Vehicule vehicule;
    @OneToOne
    private Constat constat;
    @OneToOne(mappedBy = "informationDeVehicule",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private DescriptionDeVehicule descriptionDeVehicule;
    @OneToOne(mappedBy = "informationDeVehicule",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private IdentiteDuAssure identiteDuAssure;
    @OneToOne(mappedBy = "informationDeVehicule",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private IdentiteDuConducteur identiteDuConducteur;
    @OneToOne(mappedBy = "informationDeVehicule",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private SocieteAssurance societeAssurance;
    @OneToOne(mappedBy = "informationDeVehicule",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private AutreInformation autreInformation;
}
