public interface PlanetMap {

    default int getHeight() {
        return 50;
    }
    
    default int getWidth() {
        return 50;
    }
    
    Set<Position> obstaclePositions();
}