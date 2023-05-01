package org.pfe.constat.repos;

import org.pfe.constat.models.AutreInformation;
import org.pfe.constat.requests.Request_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface AutreInformationRepository extends JpaRepository<AutreInformation, Long> {
    @Query("select degat_apparents,point_choc_initial,signature,observation,croquis from AutreInformation ")
    Request_.AutreInformation findBAutreinfoyConstatId(Long id);
}
