package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TemoinDTO {
    private String nom_complet;
    private String adresse;
    private int num_tel;
}
