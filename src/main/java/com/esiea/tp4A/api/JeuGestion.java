package com.esiea.tp4A.api;

import com.esiea.tp4A.jeu.Jeu;

import java.util.HashMap;

public class JeuGestion {
    private HashMap<String, Jeu> jeux;

    public Jeu creationJoueur(String nomJeu) throws DataAlreadyExistsException {
        try {
            checkJeu(nomJeu);
            throw new DataAlreadyExistsException("Jeu "+nomJeu+" existe déjà.");
        } catch (DataNotFoundException e) {
            Jeu jeu = new Jeu(nomJeu);
            jeux.put(nomJeu, jeu);
            return jeu;
        }
    }

    public Jeu checkJeu(String nomJeu) throws DataNotFoundException {
        if (jeux.get(nomJeu) == null) throw new DataNotFoundException("Jeu "+nomJeu+" non trouvé.");
        else return jeux.get(nomJeu);
    }




}
