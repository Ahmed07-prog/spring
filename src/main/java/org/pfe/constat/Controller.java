package org.pfe.constat;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.pfe.auth.RegisterRequest;
import org.pfe.config.JwtService;
import org.pfe.constat.DTOs.TemoinDTO;
import org.pfe.constat.models.*;
import org.pfe.constat.repos.*;
import org.pfe.constat.requests.Request;
import org.pfe.constat.requests.Request_;
import org.pfe.constat.services.ConstatService;
import org.pfe.user.Role;
import org.pfe.user.User;
import org.pfe.user.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/constat")

public class Controller {
    private final JwtService jwtService;
    private final UserRepository repository;
    private final ConstatRepository constatRepository;
    private final DescriptionDeVehiculeRepository descriptionDeVehiculeRepository;
    private final IdentiteDuAssureRepository identiteDuAssureRepository;
    private final IdentiteDuConducteurRepository identiteDuConducteurRepository;
    private final InformationGeneraleRepository informationGeneraleRepository;
    private final InformationDeVehiculeRepository informationDeVehiculeRepository;
    private final SocieteAssuranceRepository societeAssuranceRepository;
    private final TemoinRepository temoinRepository;
    private final ValidationRepository validationRepository;
    private final AutreInformationRepository autreInformationRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConstatService service;


    @PostMapping("/create")
    public ResponseEntity<?> createConstat(@RequestBody Request_ request, HttpServletRequest httpServletRequest){
        String auth = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        final String userEmail;
        String token = auth.substring(7);
        userEmail = jwtService.extractUsername(token);
        User user = repository.findUserByEmail(userEmail);
        Temoin temoin = new Temoin();
        DescriptionDeVehicule descriptionDeVehicule = new DescriptionDeVehicule();
        IdentiteDuAssure identiteDuAssure = new IdentiteDuAssure();
        IdentiteDuConducteur identiteDuConducteur = new IdentiteDuConducteur();
        AutreInformation autreInformation = new AutreInformation();
        SocieteAssurance societeAssurance = new SocieteAssurance();
        InformationGenerale informationGenerale = new InformationGenerale();
        InformationDeVehicule informationDeVehicule = new InformationDeVehicule();
        //Constat
        Constat constat = new Constat();
        constat.setUser(user);
        constat.setEtat(Etat.EN_COURS_DE_TRAITEMENT);
        constat.setMatriclue(String.valueOf(System.currentTimeMillis()));
        constat.setTemoin(temoin);
        constat.setInformationDeVehicule(informationDeVehicule);
        constat.setInformationGenerale(informationGenerale);
        //
        temoin.setConstat(constat);
        temoin.setNom_complet(request.getTemoin().getNomComplet());
        temoin.setAdresse(request.getTemoin().getAdresse());
        temoin.setNum_tel(request.getTemoin().getNumTel());
        //InformationDeVehicule
        informationDeVehicule.setConstat(constat);
        informationDeVehicule.setVehicule(Vehicule.A);
        informationDeVehicule.setAutreInformation(autreInformation);
        informationDeVehicule.setDescriptionDeVehicule(descriptionDeVehicule);
        informationDeVehicule.setIdentiteDuAssure(identiteDuAssure);
        informationDeVehicule.setIdentiteDuConducteur(identiteDuConducteur);
        informationDeVehicule.setSocieteAssurance(societeAssurance);
        //AutreInformation
        autreInformation.setInformationDeVehicule(informationDeVehicule);
        autreInformation.setObservation(request.getAutreInformation().getObservation());
        autreInformation.setPoint_choc_initial(request.getAutreInformation().getPointChocInitial());
        autreInformation.setDegat_apparents(request.getAutreInformation().getDegatApparents());
        autreInformation.setSignature(request.getAutreInformation().getSignature());
        autreInformation.setCroquis(request.getAutreInformation().getCroquis());
        //DescriptionDeVehicule
        descriptionDeVehicule.setInformationDeVehicule(informationDeVehicule);
        descriptionDeVehicule.setBrand(request.getDescriptionDeVehicule().getBrand());
        descriptionDeVehicule.setMatricule(request.getDescriptionDeVehicule().getMatricule());
        descriptionDeVehicule.setType(request.getDescriptionDeVehicule().getType());
        descriptionDeVehicule.setDirection(request.getDescriptionDeVehicule().getDirection());
        //IdentiteDuAssure
        identiteDuAssure.setInformationDeVehicule(informationDeVehicule);
        identiteDuAssure.setNom(request.getIdentiteDuAssure().getNom());
        identiteDuAssure.setPrenom(request.getIdentiteDuAssure().getPrenom());
        identiteDuAssure.setAdresse(request.getIdentiteDuAssure().getAdresse());
        //IdentiteDuConducteur
        identiteDuConducteur.setInformationDeVehicule(informationDeVehicule);
        identiteDuConducteur.setNom(request.getIdentiteDuConducteur().getNom());
        identiteDuConducteur.setPrenom(request.getIdentiteDuConducteur().getPrenom());
        identiteDuConducteur.setAdresse(request.getIdentiteDuConducteur().getAdresse());
        identiteDuConducteur.setPermis(request.getIdentiteDuConducteur().getPermis());
        identiteDuConducteur.setDate_delivration_permis(request.getIdentiteDuConducteur().getDateDelivrationPermis());
        //SocieteAssurance
        societeAssurance.setInformationDeVehicule(informationDeVehicule);
        societeAssurance.setNom_agence(request.getSocieteAssurance().getNomAgence());
        societeAssurance.setNom_complet_assure(request.getSocieteAssurance().getNomCompletAssure());
        societeAssurance.setNumero_contrat(request.getSocieteAssurance().getNumeroContrat());
        societeAssurance.setValidite_attestaion(request.getSocieteAssurance().getValidite_attestaion());
        //InformationGenerale
        informationGenerale.setConstat(constat);
        informationGenerale.setLieu(request.getInformationGenerale().getLieu());
        informationGenerale.setDate(request.getInformationGenerale().getDate());
        informationGenerale.setBlesses(request.getInformationGenerale().isBlesses());
        informationGenerale.setDegatMateriels(request.getInformationGenerale().isDegatMateriels());
        //saving data into db
        constatRepository.save(constat);
        temoinRepository.save(temoin);
        informationDeVehiculeRepository.save(informationDeVehicule);
        autreInformationRepository.save(autreInformation);
        descriptionDeVehiculeRepository.save(descriptionDeVehicule);
        identiteDuAssureRepository.save(identiteDuAssure);
        identiteDuConducteurRepository.save(identiteDuConducteur);
        societeAssuranceRepository.save(societeAssurance);
        informationGeneraleRepository.save(informationGenerale);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/count")
    public ResponseEntity<?> countConstat() {
        return ResponseEntity.ok(service.getConstatCount());
    }
    @GetMapping("/count/{id}")
    public ResponseEntity<?> countConstatByUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getConstatById(id));
    }

    @PostMapping("/validate/{id}")
    public ResponseEntity<?> validateConstat(@PathVariable("id") Long id, @RequestBody Request request, HttpServletRequest httpServletRequest) {
        String auth = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        final String userEmail;
        String token = auth.substring(7);
        userEmail = jwtService.extractUsername(token);
        User user = repository.findUserByEmail(userEmail);
        ExpertValidation validation = new ExpertValidation();
        Constat constat = constatRepository.findConstatById(id);
        if (constat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Constat not found");
        }
        String expertValidation = request.getExpertValidation().getAvis();
        if (expertValidation == null) {
            return ResponseEntity.badRequest().body("Validation not found in the request");
        }
        validation.setConstat(constat);
        validation.setUser(user);
        validation.setAvis(expertValidation);
        validationRepository.save(validation);
        constat.setEtat(Etat.TRAITED);
        constat.setExpertValidation(validation);
        constatRepository.save(constat);
        return ResponseEntity.ok("Avis Added Successfully");
    }

@GetMapping("/all")
    public ResponseEntity<?> getAllConstat() {
        return ResponseEntity.ok(service.getAllConstat());
    }

@GetMapping("/{id}")
    public ResponseEntity<?> getConstatById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getConstatById(id));
    }
@PostMapping("/add")
@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addNewEexpert(@RequestBody RegisterRequest request) {
        //Add credential verfications from the other backend
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .phone(request.getPhone())
                .cin(request.getCin())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.EXPERT)
                .build();
        repository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
