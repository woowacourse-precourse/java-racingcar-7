package racingcar.domain;

import racingcar.common.Random;

public class Car {
	private static final int START_POSITION = 0;
	private static final int MOVE_CONDITION = 4;
	private static final int MOVE_AMOUNT = 1;

	private final String name;
	private int position;

	public Car(String name, CarValidator carValidator) {
		carValidator.validateCarName(name);

		this.name = name;
		this.position = START_POSITION;
	}

	public void tryMove(Random random) {
		boolean canMove = random.pickRandomNumber() >= MOVE_CONDITION;
		if (canMove) {
			move();
		}
	}

	public int getPosition(){
		return position;
	}

	public String getName(){
		return name;
	}

	private void move() {
		position += MOVE_AMOUNT;
	}

}
