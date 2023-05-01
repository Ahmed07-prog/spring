package org.pfe.constat.repos;

import org.pfe.constat.models.IdentiteDuConducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IdentiteDuConducteurRepository extends JpaRepository<IdentiteDuConducteur, Long> {
}
