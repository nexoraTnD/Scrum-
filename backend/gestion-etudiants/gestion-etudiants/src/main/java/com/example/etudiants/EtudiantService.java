package com.example.etudiants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EtudiantService {
    private final Map<Long, Etudiant> etudiants = new LinkedHashMap<>();
    private long prochainId = 1;

    public synchronized Etudiant ajouter(AjoutEtudiant demande) {
        long id = prochainId++;
        Etudiant etudiant = new Etudiant(id, demande.nom(), demande.prenom(), demande.email());
        etudiants.put(id, etudiant);
        return etudiant;
    }

    public synchronized List<Etudiant> lister() {
        return List.copyOf(etudiants.values());
    }

    public synchronized Optional<Etudiant> retrouver(long id) {
        return Optional.ofNullable(etudiants.get(id));
    }
}

