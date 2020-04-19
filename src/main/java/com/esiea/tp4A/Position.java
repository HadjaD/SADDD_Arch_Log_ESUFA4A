package com.esiea.tp4A;

public interface Position {

    int getX();
    int getY();
    Direction getDirection();

    static Position of(int x, int y, Direction direction) {
        return new FixedPosition(x, y, direction);
    }

    Position forward(PlanetMap map);
    Position backward(PlanetMap map);
    Position left();
    Position right();

    final class FixedPosition implements Position {

        private final int x;
        private final int y;
        public boolean isObstacle;
        private final Direction direction;
        //private PlanetMap planetMap;
        private int planetHeight = 25;//planetMap.getHeight()/2;
        private int planetWidth = 25;//planetMap.getWidth()/2;

        public FixedPosition(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.isObstacle = false;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public Direction getDirection() {
            return direction;
        }

        @Override
        public Position forward(PlanetMap map) {
           /* switch (direction){
                case NORTH:
                    return rotation(x, y, )
                    //return Position.of(x,y + 1, direction);
                case SOUTH:
                    return Position.of(x,y - 1, direction);
                case WEST:
                    return Position.of(x - 1 , y , direction);
                case EAST:
                    return Position.of(x + 1, y, direction);
                return rotation(x, y, direction);
            }*/
            return rotationForward(x, y, direction, map);
           // throw new IllegalStateException("No move from direction" + direction);
        }
        public Position rotationForward(int x, int y, Direction direction, PlanetMap map){
            int newX, newY;
            switch (direction){
                case NORTH:
                    if(y < planetHeight){
                        newY = y + 1;
                    }else{
                        newY = -planetHeight + 1;
                    }
                    return !hasObstacle(x, newY, map) ? Position.of(x, newY, direction): Position.of(x, y, direction);
                    //return y < planetHeight ? Position.of(x, y + 1, direction) : Position.of(x, -planetHeight + 1, direction);
                case SOUTH:
                    if(y > -planetHeight + 1){
                        newY = y - 1;
                    }else{
                        newY = planetHeight;
                    }
                    return !hasObstacle(x, newY, map) ? Position.of(x, newY, direction): Position.of(x, y, direction);
                    //return y > -planetHeight + 1 ? Position.of(x, y - 1, direction) : Position.of(x, planetHeight, direction);
                case WEST:
                    if(x > -planetWidth + 1){
                        newX = x - 1;
                    }else{
                        newX = planetWidth;
                    }
                    return !hasObstacle(newX, y, map) ? Position.of(newX, y, direction): Position.of(x, y, direction);
                    //return x > -planetWidth + 1 ? Position.of(x  - 1, y, direction) : Position.of(planetWidth, y, direction);
                case EAST:
                    if(x < planetWidth){
                        newX = x + 1;
                    }else{
                        newX = -planetWidth + 1;
                    }
                    return !hasObstacle(newX, y, map) ? Position.of(newX, y, direction): Position.of(x, y, direction);
                    //return x < planetWidth ? Position.of(x + 1, y, direction) : Position.of(-planetWidth + 1, y, direction);


            }
            throw new IllegalStateException("No move from direction" + direction);
        }

        public Position rotationBackward(int x, int y, Direction direction, PlanetMap map){
            int newX, newY;
            switch (direction){
                case NORTH:
                    if(y <= planetHeight && y > -planetHeight + 1){
                        newY = y - 1;
                    }else{
                        newY = planetHeight;
                    }
                    return !hasObstacle(x, newY, map) ? Position.of(x, newY, direction): Position.of(x, y, direction);
                    //return y <= planetHeight && y > -planetHeight + 1? Position.of(x, y - 1, direction) : Position.of(x, planetHeight, direction);
                case SOUTH:
                    if(y < planetHeight && y > -planetHeight){
                        newY = y + 1;
                    }else{
                        newY = -planetHeight + 1;
                    }
                    return !hasObstacle(x, newY, map) ? Position.of(x, newY, direction): Position.of(x, y, direction);
                   // return y > -planetHeight && y < planetHeight? Position.of(x, y + 1, direction) : Position.of(x, -planetHeight + 1, direction);
                case WEST:
                    if(x < planetWidth && x > -planetWidth + 1){
                        newX = x + 1;
                    }else{
                        newX = -planetWidth + 1;
                    }
                    return !hasObstacle(newX, y, map) ? Position.of(newX, y, direction): Position.of(x, y, direction);
                    //return x < planetWidth && x > -planetWidth + 1 ? Position.of(x + 1, y, direction) : Position.of(-planetWidth + 1 , y, direction);
                case EAST:
                    if(x > -planetWidth + 1 && x < planetWidth){
                        newX = x - 1;
                    }else{
                        newX = planetWidth;
                    }
                    return !hasObstacle(newX, y, map) ? Position.of(newX, y, direction): Position.of(x, y, direction);
                    //return x > -planetWidth + 1 && x < planetWidth ? Position.of(x - 1, y, direction) : Position.of(planetWidth, y, direction);


            }
            throw new IllegalStateException("No move from direction" + direction);
        }
        @Override
        public Position backward(PlanetMap map) {
            /*switch (direction){
                case NORTH:
                    return Position.of(x,y - 1, direction);
                case SOUTH:
                    return Position.of(x,y +  1, direction);
                case WEST:
                    return Position.of(x + 1 , y , direction);
                case EAST:
                    return Position.of(x - 1, y, direction);
            }
            throw new IllegalStateException("No move from direction" + direction);*/
            return rotationBackward(x, y, direction, map);
        }

        @Override
        public Position left() {
            return Position.of(x, y, direction.left());
        }

        @Override
        public Position right() {
            return Position.of(x, y, direction.right());
        }
        private boolean hasObstacle(int x, int y, PlanetMap map) {
            for (Position obstacle : map.obstaclePositions()) {
                if (obstacle.getX() == x && obstacle.getY() == y) {
                   isObstacle = true;
                    return true;
                }
            }
            return false;
        }

    }
}
