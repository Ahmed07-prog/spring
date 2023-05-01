package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class SocieteAssuranceDTO {
    private String nom_complet_assure;
    private int numero_contrat;
    private String nom_agence;
    private Date validite_attestaion;
}
