package org.pfe.constat.repos;

import org.pfe.constat.models.SocieteAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteAssuranceRepository extends JpaRepository<SocieteAssurance, Long> {
}
