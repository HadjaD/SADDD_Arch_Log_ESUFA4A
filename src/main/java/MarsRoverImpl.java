package com.esiea.tp4A.domain;

public class MarsRoverImpl implements MarsRover {

	private Position position;

	public MarsRoverImpl(int x, int y, Direction direction) {
		position = Position.of(x, y, direction);
	}

	@Override
	public Position move(String command) {
		if (command.isEmpty()) {
			return Position.of(0, 0, Direction.NORTH);
		}
		for(char singleCommand: command.toCharArray()) {
			if ('f' == singleCommand) {
				position = position.forward();
			} else if ('b' == singleCommand) {
				position = position.backward();
			} else if ('l' == singleCommand) {
				position = position.left();
			} else {
				position = position.right();
			}
		}

		return position;
	}
}
