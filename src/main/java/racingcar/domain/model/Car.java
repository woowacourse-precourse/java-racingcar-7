package racingcar.domain.model;

import racingcar.common.util.GameConstants;
import racingcar.common.util.RandomNumberGenerator;
import racingcar.common.util.Validator;

public class Car {

	private final String name;
	private final Position position;

	public Car(String name) {
		Validator.validateName(name);
		this.name = name;
		position = new Position(0);
	}

	public void moveForward(RandomNumberGenerator randomNumberGenerator) {

		int number = randomNumberGenerator.generateNumber(GameConstants.MIN_PICK_NUMBER, GameConstants.MAX_PICK_NUMBER);

		if (number >= GameConstants.FORWARD_MINIMUM_VALUE) {
			position.increase();
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position.getValue();
	}

	public RaceStatus toStatus() {
		return new RaceStatus(name, getPosition());
	}
}
