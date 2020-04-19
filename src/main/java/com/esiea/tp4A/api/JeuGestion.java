package com.esiea.tp4A.api;

import com.esiea.tp4A.jeu.Mars;
import com.esiea.tp4A.jeu.Rover;
import com.esiea.tp4A.jeu.PlayerOutput;
import com.esiea.tp4A.jeu.Jeu;

import java.util.HashMap;

public class JeuGestion {
    private HashMap<String, Jeu> jeux;
    public JeuGestion(HashMap<String, Jeu> jeux) { this.jeux = jeux; }

    public Jeu createGame(String gameName) throws DataAlreadyExistsException {
        try {
            checkGame(gameName);
            throw new DataAlreadyExistsException("Game "+gameName+" already exists.");
        } catch (DataNotFoundException e) {
            Jeu jeu = new Jeu(gameName,new Mars());
            jeux.put(gameName, jeu);//new ServerData().saveGame(gameName, game);
            return jeu;
        }
    }

    public Jeu checkGame(String gameName) throws DataNotFoundException {
        if (jeux.get(gameName) == null) throw new DataNotFoundException("Game "+gameName+" not found.");
        else return jeux.get(gameName);
    }

    public PlayerOutput createRover(String gameName, String playerName) throws DataNotFoundException, DataAlreadyExistsException {
        Jeu game = checkGame(gameName);
        try {
            getRover(game, playerName);
            throw new DataAlreadyExistsException("Player "+playerName+" already exists.");
        } catch (DataNotFoundException e)  {
            Rover rover = game.createPlayer(playerName);
            jeux.replace(gameName, game);//new ServerData().saveGame(gameName, game);
            return new PlayerOutput(rover, game.getPlayerLocalMap(rover.getPlayer(), 30));
        }
    }
    public PlayerOutput getRover(Jeu game, String playerName) throws DataNotFoundException {
        Rover rover = game.retrieveRoverByPlayer(playerName);
        if (rover == null) throw new DataNotFoundException("Player "+playerName+" not found.");
        else return new PlayerOutput(rover, game.getPlayerLocalMap(rover.getPlayer(), 30));
    }

    public PlayerOutput moveRover(String gameName, String playerName, String command) throws DataNotFoundException {
        Jeu jeu = checkGame(gameName);
        Rover rover = jeu.playerMove(playerName, command);
        if(rover == null) throw new DataNotFoundException("Player "+playerName+" not found.");
        PlayerOutput playerOutput = new PlayerOutput(rover, jeu.getPlayerLocalMap(rover.getPlayer(), 30));
        jeux.replace(gameName, jeu);//new ServerData().saveGame(gameName, game);
        return playerOutput;
    }

}
