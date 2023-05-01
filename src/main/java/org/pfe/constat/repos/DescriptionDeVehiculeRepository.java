package org.pfe.constat.repos;

import org.pfe.constat.models.DescriptionDeVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DescriptionDeVehiculeRepository extends JpaRepository<DescriptionDeVehicule, Long> {
}

