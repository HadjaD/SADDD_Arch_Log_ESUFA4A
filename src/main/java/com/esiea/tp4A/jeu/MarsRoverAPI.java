package com.esiea.tp4A.jeu;

import com.esiea.tp4A.domain.Position;

public interface MarsRoverAPI {
    Position getPosition(String player);
    CarteJeu carteJeu(String joueur, int tailleCarteJoueur);
}
