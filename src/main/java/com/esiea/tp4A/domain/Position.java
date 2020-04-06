package com.esiea.tp4A.domain;

public interface Position {

    int getX();
    int getY();
    Direction getDirection();

    static Position of(int x, int y, Direction direction) {
        return new FixedPosition(x, y, direction);
    }

    Position forward();
    Position backward();
    Position left();
    Position right();

    final class FixedPosition implements Position {

        private final int x;
        private final int y;
        private final Direction direction;
        //private PlanetMap planetMap;
        private int planetHeight = 25;//planetMap.getHeight()/2;
        private int planetWidth = 25;//planetMap.getWidth()/2;

        public FixedPosition(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;

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
        public Position forward() {
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
            return rotationForward(x, y, direction);
           // throw new IllegalStateException("No move from direction" + direction);
        }
        public Position rotationForward(int x, int y, Direction direction){
            switch (direction){
                case NORTH:
                    return y < planetHeight ? Position.of(x, y + 1, direction) : Position.of(x, -planetHeight + 1, direction);
                case SOUTH:
                        return y > -planetHeight ? Position.of(x, y - 1, direction) : Position.of(x, -planetHeight + 1, direction);
                case WEST:
                    return x > -planetWidth ? Position.of(x - 1, y, direction) : Position.of(-planetWidth + 1 , y, direction);
                case EAST:
                    return x < planetWidth ? Position.of(x + 1, y, direction) : Position.of(-planetWidth + 1, y, direction);


            }
            return Position.of(x, y, direction);
        }

        @Override
        public Position backward() {
            switch (direction){
                case NORTH:
                    return Position.of(x,y - 1, direction);
                case SOUTH:
                    return Position.of(x,y +  1, direction);
                case WEST:
                    return Position.of(x + 1 , y , direction);
                case EAST:
                    return Position.of(x - 1, y, direction);
            }
            throw new IllegalStateException("No move from direction" + direction);
        }

        @Override
        public Position left() {
            return Position.of(x ,y , direction.left());
        }

        @Override
        public Position right() {
            return Position.of(x,y, direction.right());
        }

    }
}
