package com.esiea.tp4A.jeu;

import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.PlanetMap;

import java.util.HashSet;
import java.util.Set;

public class PlanetMapInit implements PlanetMap {
    private final int height;
    private final int weight;
    private Set<Position> obstacles;
    private final double rate;
    public PlanetMapInit(int height, int weight, double rate){
        this.height = height;
        this.weight = weight;
        this.rate = rate;
        this.obstacles = new HashSet<Position>();
        //initObstacles();
    }
    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.weight;
    }

    @Override
    public Set<Obstacle> obstaclePositions() {
        return obstacles;

    }

    public void initObstacles() {
        this.obstacles = new HashSet<Position>();
        int x = getHeight() / 2, x_ = -x + 1, y = getWidth() / 2, y_ = -y + 1;
        int nbObstacles = (int) ((int) x * y * 4 * rate);
        for (int i = 0; i < nbObstacles; i++) {
            this.obstacles.add(Position.of((int) (Math.random() * (x - x_)) + x_,
                (int) (Math.random() * (y - y_)) + y_, Direction.NORTH));
        }
    }
    public void addObstacle(Position position){
        this.obstacles.add(position);
    }
    public void removeObstacle(Position position){
        this.obstacles.remove(position);
    }
    public Set<Position> getObstacles(){
        return this.obstacles;
    }
}
