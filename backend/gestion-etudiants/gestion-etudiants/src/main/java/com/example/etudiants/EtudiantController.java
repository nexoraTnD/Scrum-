package com.example.etudiants;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Etudiant> ajouter(@Valid @RequestBody AjoutEtudiant demande) {
        Etudiant etudiant = service.ajouter(demande);
        URI adresse = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(etudiant.id()).toUri();
        return ResponseEntity.created(adresse).body(etudiant);
    }

    @GetMapping
    public List<Etudiant> lister() {
        return service.lister();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> retrouver(@PathVariable long id) {
        return ResponseEntity.of(service.retrouver(id));
    }
}

