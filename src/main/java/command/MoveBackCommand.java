package command;

import car.Car;

public class MoveBackCommand implements Command {
    @Override
    public void execute(Car car) {
        car.moveBack();
    }
}
