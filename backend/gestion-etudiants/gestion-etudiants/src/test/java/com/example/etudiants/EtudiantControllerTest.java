package com.example.etudiants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EtudiantControllerTest {

    private static final String ROUTE = "/api/etudiants";
    private static final String ETUDIANT_VALIDE = """
            {"nom":"Ben Ali","prenom":"Mariem","email":"mariem@example.com"}
            """;

    private MockMvc mvc;

    @BeforeEach
    void preparer() {
        mvc = MockMvcBuilders.standaloneSetup(
                new EtudiantController(new EtudiantService())
        ).build();
    }

    @Test
    void listerLesEtudiantsRetourneUnTableauJson() throws Exception {
        mvc.perform(get(ROUTE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }

    @Test
    void ajouterUnEtudiantValidePuisLeRetrouver() throws Exception {
        mvc.perform(post(ROUTE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ETUDIANT_VALIDE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));

        mvc.perform(get(ROUTE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));

        mvc.perform(get(ROUTE + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nom").value("Ben Ali"))
                .andExpect(jsonPath("$.prenom").value("Mariem"))
                .andExpect(jsonPath("$.email").value("mariem@example.com"));
    }

    @Test
    void retrouverUnEtudiantInexistantRetourne404() throws Exception {
        mvc.perform(get(ROUTE + "/999"))
                .andExpect(status().isNotFound());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "{\"prenom\":\"Mariem\",\"email\":\"mariem@example.com\"}",
            "{\"nom\":\"Ben Ali\",\"email\":\"mariem@example.com\"}",
            "{\"nom\":\"Ben Ali\",\"prenom\":\"Mariem\",\"email\":\"invalide\"}"
    })
    void refuserUnEtudiantInvalide(String donnees) throws Exception {
        mvc.perform(post(ROUTE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(donnees))
                .andExpect(status().isBadRequest());

        mvc.perform(get(ROUTE))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}