package org.pfe.constat.repos;

import org.pfe.constat.models.IdentiteDuAssure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IdentiteDuAssureRepository extends JpaRepository<IdentiteDuAssure, Long> {
}
