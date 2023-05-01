package org.pfe.constat.repos;

import org.pfe.constat.models.InformationDeVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InformationDeVehiculeRepository extends JpaRepository<InformationDeVehicule, Long> {
}
