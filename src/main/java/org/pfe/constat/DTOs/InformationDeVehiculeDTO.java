package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.pfe.constat.models.DescriptionDeVehicule;
import org.pfe.constat.models.IdentiteDuAssure;
import org.pfe.constat.models.IdentiteDuConducteur;
import org.pfe.constat.models.Vehicule;

@AllArgsConstructor
@Getter
@Setter
public class InformationDeVehiculeDTO {
    private Vehicule vehicule;
    private DescriptionDeVehiculeDTO descriptionDeVehicule;
    private IdentiteDuAssureDTO identiteDuAssure;
    private IdentiteDuConducteurDTO identiteDuConducteur;
    private SocieteAssuranceDTO societeAssurance;



}
