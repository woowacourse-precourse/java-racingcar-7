package racingcar.racinggame.race.car;

import java.util.List;

public class Car {

	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final int INITIAL_MOVE_DISTANCE = 0;
	private static final int MOVE_CONDITION = 4;
	private static final int MIN_RANDOM_VALUE = 0;
	private static final int MAX_RANDOM_VALUE = 9;
	private static final String OVER_FLOW_CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
	private static final String BLANK_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 존재해야 합니다.";
	private static final String OVER_FLOW_RANDOM_VALUE_RANGE_ERROR_MESSAGE = "무작위 값의 범위는 0~9 사이입니다.";

	private final String name;
	private int moveDistance;

	private Car(String name, int moveDistance) {
		validateName(name);

		this.name = name;
		this.moveDistance = moveDistance;
	}

	public static Car create(String name) {
		return new Car(name, INITIAL_MOVE_DISTANCE);
	}

	private static boolean isPossibleToMove(int randomValue) {
		return randomValue >= MOVE_CONDITION;
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

	public void move(int randomValue) {
		validateRandomValueRange(randomValue);

		if (isPossibleToMove(randomValue)) {
			moveDistance++;
		}
	}

	private void validateRandomValueRange(int randomValue) {
		if (randomValue < MIN_RANDOM_VALUE || randomValue > MAX_RANDOM_VALUE) {
			throw new IllegalStateException(OVER_FLOW_RANDOM_VALUE_RANGE_ERROR_MESSAGE);
		}
	}

	public boolean isFurthestIn(List<Car> others) {
		return others.stream()
			.filter(car -> car.isFurtherThan(this))
			.findAny()
			.isEmpty();
	}

	private boolean isFurtherThan(Car other) {
		return moveDistance > other.moveDistance;
	}

	public String getName() {
		return name;
	}

	public int getMoveDistance() {
		return moveDistance;
	}
}
