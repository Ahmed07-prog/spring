package org.pfe.constat.services;

import lombok.RequiredArgsConstructor;
import org.pfe.constat.DTOs.*;
import org.pfe.constat.models.*;
import org.pfe.constat.repos.*;
import org.pfe.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConstatService {

    private final ConstatRepository constatRepository;
    private final UserService service;
    public List<ConstatDTO> getAllConstat() {
        List<Constat> constats = constatRepository.findAll();
        return getConstatDTOS(constats);
    }
    public List<ConstatDTO> getConstatById(Long id) {
        List<Constat> constats = constatRepository.findAllById(Collections.singleton(id));
        return getConstatDTOS(constats);
    }

    public Long getConstatCount() {
        return constatRepository.count();
    }
    private Long getConstatCountByUser(Long id) {
        return constatRepository.countByUser_Id(id);
    }



    private List<ConstatDTO> getConstatDTOS(List<Constat> constats) {
        return constats.stream()
                .map(constat -> new ConstatDTO(constat.getUser().getEmail(),constat.getUser().getId(),constat.getId(), constat.getMatriclue(), constat.getEtat(),
                        new InformationGeneraleDTO( constat.getInformationGenerale().getDate(), constat.getInformationGenerale().getLieu(), constat.getInformationGenerale().getBlesses(), constat.getInformationGenerale().getDegatMateriels()),
                        new TemoinDTO(constat.getTemoin().getNom_complet(),constat.getTemoin().getAdresse(),constat.getTemoin().getNum_tel()),
                        new ValidationDTO(constat.getExpertValidation().getAvis()),
                        new InformationDeVehiculeDTO(
                                constat.getInformationDeVehicule().getVehicule(),
                                new DescriptionDeVehiculeDTO(constat.getInformationDeVehicule().getDescriptionDeVehicule().getType(),constat.getInformationDeVehicule().getDescriptionDeVehicule().getBrand(),constat.getInformationDeVehicule().getDescriptionDeVehicule().getDirection(),constat.getInformationDeVehicule().getDescriptionDeVehicule().getMatricule()),
                                new IdentiteDuAssureDTO(constat.getInformationDeVehicule().getIdentiteDuAssure().getNom(),constat.getInformationDeVehicule().getIdentiteDuAssure().getPrenom(),constat.getInformationDeVehicule().getIdentiteDuAssure().getAdresse()),
                                new IdentiteDuConducteurDTO(constat.getInformationDeVehicule().getIdentiteDuConducteur().getNom(),constat.getInformationDeVehicule().getIdentiteDuConducteur().getPrenom(),constat.getInformationDeVehicule().getIdentiteDuConducteur().getAdresse(),constat.getInformationDeVehicule().getIdentiteDuConducteur().getPermis(),constat.getInformationDeVehicule().getIdentiteDuConducteur().getDate_delivration_permis()),
                                new SocieteAssuranceDTO(constat.getInformationDeVehicule().getSocieteAssurance().getNom_complet_assure(),constat.getInformationDeVehicule().getSocieteAssurance().getNumero_contrat(),constat.getInformationDeVehicule().getSocieteAssurance().getNom_agence(),constat.getInformationDeVehicule().getSocieteAssurance().getValidite_attestaion()))))
                .collect(Collectors.toList());
    }


}
