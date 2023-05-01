package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class InformationGeneraleDTO {
    private Date date;
    private String lieu;
    private Boolean blesses;
    private Boolean degatMateriels;
}
