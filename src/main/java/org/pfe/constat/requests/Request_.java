package org.pfe.constat.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request_ {

    @JsonProperty("temoin")
    private Temoin   temoin;

    @JsonProperty("information_generale")
    private InformationGenerale informationGenerale;

    @JsonProperty("autre_information")
    private AutreInformation autreInformation;

    @JsonProperty("description_de_vehicule")
    private DescriptionDeVehicule descriptionDeVehicule;

    @JsonProperty("identite_du_assure")
    private IdentiteDuAssure identiteDuAssure;

    @JsonProperty("identite_du_conducteur")
    private IdentiteDuConducteur identiteDuConducteur;

    @JsonProperty("societe_assurance")
    private SocieteAssurance societeAssurance;

    public static Request_ fromJson(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Request_.class);
    }

    public String toJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
    @Getter
    @Setter
    public static class Temoin {

        @JsonProperty("nom_complet")
        private String nomComplet;

        @JsonProperty("adresse")
        private String adresse;

        @JsonProperty("num_tel")
        private int numTel;

    }
    @Getter
    @Setter
    public static class InformationGenerale {

        @JsonProperty("lieu")
        private String lieu;

        @JsonProperty("date")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private Date date;

        @JsonProperty("blesses")
        private boolean blesses;

        @JsonProperty("degat_materiels")
        private boolean degatMateriels;

// getters and setters
    }
@Getter
@Setter
    public static class AutreInformation {
        @JsonProperty("point_choc_initial")
        private String pointChocInitial;

        @JsonProperty("signature")
        private String signature;

        @JsonProperty("degat_apparents")
        private String degatApparents;

        @JsonProperty("croquis")
        private String croquis;

        @JsonProperty("observation")
        private String observation;

        // getters and setters
    }
    @Getter
    @Setter
    public static class DescriptionDeVehicule {

        @JsonProperty("brand")
        private String brand;

        @JsonProperty("matricule")
        private String matricule;

        @JsonProperty("type")
        private String type;

        @JsonProperty("direction")
        private String direction;

        // getters and setters
    }
    @Getter
    @Setter
    public static class IdentiteDuAssure {

        @JsonProperty("nom")
        private String nom;

        @JsonProperty("prenom")
        private String prenom;

        @JsonProperty("adresse")
        private String adresse;

        // getters and setters
    }
    @Getter
    @Setter
    public static class IdentiteDuConducteur {

        @JsonProperty("nom")
        private String nom;

        @JsonProperty("prenom")
        private String prenom;

        @JsonProperty("adresse")
        private String adresse;

        @JsonProperty("permis")
        private String permis;

        @JsonProperty("date_delivration_permis")
        private Date dateDelivrationPermis;

        // getters and setters
    }
    @Getter
    @Setter
    public static class SocieteAssurance {

        @JsonProperty("nom_agence")
        private String nomAgence;

        @JsonProperty("nom_complet_assure")
        private String nomCompletAssure;

        @JsonProperty("numero_contrat")
        private int numeroContrat;
        @JsonProperty("validite_attestaion")
        private Date validite_attestaion;

    }

}
