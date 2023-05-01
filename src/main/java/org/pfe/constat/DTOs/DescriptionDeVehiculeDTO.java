package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DescriptionDeVehiculeDTO {
    private String type;
    private String brand;
    private String direction;
    private String matricule;
}
