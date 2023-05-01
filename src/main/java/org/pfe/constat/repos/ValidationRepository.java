package org.pfe.constat.repos;

import org.pfe.constat.models.ExpertValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<ExpertValidation, Long> {
}
