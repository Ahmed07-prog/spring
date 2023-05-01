package org.pfe.constat.repos;

import org.pfe.constat.models.InformationGenerale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InformationGeneraleRepository extends JpaRepository<InformationGenerale, Long> {
}
