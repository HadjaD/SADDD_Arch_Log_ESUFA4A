package com.esiea.tp4A.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.emptySet;

public class PlanetMapInit implements PlanetMap {
    private int height;
    private int weight;
    private Set<Position> obstacles;
    double rate;
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
    public Set<Position> obstaclePositions() {
        return obstacles;

    }

    public void initObstacles() {
        this.obstacles = new HashSet<Position>();
        int x = getHeight() / 2;
        int x_ = -x + 1;
        int y = getWidth() / 2;
        int y_ = -y + 1;
        int nbObstacles = (int) ((int) x * y * 4 * rate);
        int xObstacle;
        int yObstacle;
        for (int i = 0; i < nbObstacles; i++) {
            xObstacle = (int) (Math.random() * (x - x_)) + x_;
            yObstacle = (int) (Math.random() * (y - y_)) + y_;
            this.obstacles.add(Position.of(xObstacle, yObstacle, Direction.NORTH));

            //addObstacles(position);
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
