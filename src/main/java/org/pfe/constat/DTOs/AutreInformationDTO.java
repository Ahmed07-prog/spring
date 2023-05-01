package org.pfe.constat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AutreInformationDTO {
    private String point_choc_initial;
    private String degat_apparents;
    private String observation;
    private String croquis;
    private String signature;
}
