package org.pfe.constat.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class InformationGenerale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String lieu;
    private Boolean blesses;
    private Boolean degatMateriels;
    @OneToOne
    private Constat constat;
}
