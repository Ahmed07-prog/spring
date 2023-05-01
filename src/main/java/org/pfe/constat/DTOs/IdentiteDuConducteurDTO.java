package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class IdentiteDuConducteurDTO {
    private String nom;
    private String prenom;
    private String adresse;
    private String permis;
    private Date date_delivration_permis;
}
