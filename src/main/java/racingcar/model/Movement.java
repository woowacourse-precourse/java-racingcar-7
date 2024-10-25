package racingcar.model;

public class Movement {

	private static final int INITIAL_MOVEMENT_VALUE = 0;
	private static final int MIN_REQUIRED_VALUE_FOR_MOVEMENT = 4;
	private static final int MOVEMENT_VALUE = 1;

	private int movement;

	public Movement() {
		this.movement = INITIAL_MOVEMENT_VALUE;
	}

	public void move(int number) {
		if (number >= MIN_REQUIRED_VALUE_FOR_MOVEMENT) {
			movement += MOVEMENT_VALUE;
		}
	}
}
