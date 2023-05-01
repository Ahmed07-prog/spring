package org.pfe.constat.models;

import jakarta.persistence.*;
import lombok.*;
import org.pfe.user.User;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Constat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matriclue;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "constat",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private InformationGenerale informationGenerale;
    @OneToOne(mappedBy = "constat",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Temoin temoin;
    @OneToOne(mappedBy = "constat",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ExpertValidation expertValidation;
    @OneToOne(mappedBy = "constat",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private InformationDeVehicule informationDeVehicule;

}
