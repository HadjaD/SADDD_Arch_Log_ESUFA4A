package car;


import command.Command;
import utils.Surface;

import java.util.ArrayList;

public class Car {
    private final Surface surface;
    private int coordinateX;
    private int coordinateY;
    private Direction direction;

    public Car(Surface surface, int coordinateX, int coordinateY, Direction direction) {
        if (surface == null) throw new NullPointerException("La Surface sur laquelle vous créez le Véhicule ne peut pas être nul !");
        if (direction == null) throw new NullPointerException("La direction dans laquelle le Véhicule fait face ne peut pas être nulle !");

        this.surface = surface;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.direction = direction;
        validateLocation();
    }

    private Surface getSurface() {
        return surface;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void executeCommandList(ArrayList<Command> commands) {
        for (Command command : commands)
            command.execute(this);
    }

    public void spinRight() {
        direction = getDirection().turnRight();
    }

    public void spinLeft() {
        direction = getDirection().turnLeft();
    }

    public void moveForward() {
        getDirection().moveForward(this);
        validateLocation();
    }

    public void moveBack() {
        getDirection().moveBack(this);
        validateLocation();
    }

    public String broadcastLocation() {
        return coordinateX + " "
                + coordinateY + " "
                + Character.toString(getDirection().getClass().getSimpleName().charAt(0));
    }

    private void validateLocation() {
        if (this.getCoordinateX() > this.getSurface().getUpperBoundCoordinateX()
                || this.getCoordinateY() > this.getSurface().getUpperBoundCoordinateY()
                || this.getCoordinateX() < this.getSurface().getLowerBoundCoordinateX()
                || this.getCoordinateY() < this.getSurface().getLowerBoundCoordinateY())
            throw new CarOutOfBoundsException();
    }
}
