package org.pfe.constat.repos;

import org.pfe.constat.models.Constat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConstatRepository extends JpaRepository<Constat, Long> {
    Constat findConstatById(Long id);

    Long countByUser_Id(Long id);
}
