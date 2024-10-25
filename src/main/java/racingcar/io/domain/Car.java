package racingcar.io.domain;

public class Car {

	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final String OVER_FLOW_CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
	private static final String BLANK_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 존재해야 합니다.";
	private static final int INITIAL_MOVE_DISTANCE = 0;
	private static final int MOVE_CONDITION = 4;

	private final String name;
	private int moveDistance;

	private Car(String name, int moveDistance) {

		validateName(name);

		this.name = name;
		this.moveDistance = moveDistance;
	}

	private void validateName(String name) {
		validateBlankName(name);
		validateNameLength(name);
	}

	private void validateBlankName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(BLANK_CAR_NAME_ERROR_MESSAGE);
		}
	}

	private void validateNameLength(String name) {
		if (name.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(OVER_FLOW_CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	public static Car create(String name) {
		return new Car(name, INITIAL_MOVE_DISTANCE);
	}

	public void move(int randomValue) {
		if(isPossibleToMove(randomValue)) {
			moveDistance++;
		}
	}

	private static boolean isPossibleToMove(int randomValue) {
		return randomValue > MOVE_CONDITION;
	}

}
