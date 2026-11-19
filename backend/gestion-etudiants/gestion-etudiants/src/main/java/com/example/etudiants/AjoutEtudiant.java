package com.example.etudiants;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AjoutEtudiant(
        @NotBlank String nom,
        @NotBlank String prenom,
        @NotBlank @Email String email
) {
}

