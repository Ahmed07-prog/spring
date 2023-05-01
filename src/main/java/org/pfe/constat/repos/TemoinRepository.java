package org.pfe.constat.repos;

import org.pfe.constat.models.Temoin;

import org.pfe.constat.requests.Request_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemoinRepository extends JpaRepository<Temoin,Long> {
    @Query("SELECT nom_complet,num_tel,adresse from Temoin ")
    Request_.Temoin findTemoinByConstatId(Long id);
}
