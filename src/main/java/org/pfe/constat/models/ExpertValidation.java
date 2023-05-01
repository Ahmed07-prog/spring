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
public class ExpertValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String avis;
    @OneToOne
    private Constat constat;
    @ManyToOne
    public User user;


}
