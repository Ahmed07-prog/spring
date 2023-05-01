package org.pfe.constat.DTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.pfe.constat.models.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ConstatDTO {

    private String username;
    private Long userID;
    private Long id;
    private String matriclue;
    private Etat etat;
   private InformationGeneraleDTO informationGenerale;
   private TemoinDTO temoin;
    private ValidationDTO validation;
    private InformationDeVehiculeDTO vehicule;
}
