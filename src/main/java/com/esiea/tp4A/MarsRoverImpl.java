package com.esiea.tp4A;

public class MarsRoverImpl implements MarsRover {

	private Position position;
	private PlanetMap map;

	public MarsRoverImpl(int x, int y, Direction direction, PlanetMap map) {
		position = Position.of(x, y, direction);
		this.map = map;
	}

	@Override
	public Position move(String command) {
		if (command.isEmpty()) {
			//return Position.of(0, 0, Direction.NORTH);
            return position;
		}
		for(char singleCommand: command.toCharArray()) {
			if ('f' == singleCommand) {
				position = position.forward(this.map);
			} else if ('b' == singleCommand) {
				position = position.backward(this.map);
			} else if ('l' == singleCommand) {
				position = position.left();
			} else {
				position = position.right();
			}
		}
		return position;
	}
}
