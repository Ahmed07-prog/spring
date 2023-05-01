package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class IdentiteDuAssureDTO {
    private String nom_assure;
    private String prenom_assure;
    private String adresse;
}
