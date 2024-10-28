package racingcar.model.car;

import static racingcar.model.message.ErrorMessage.INVALID_CAR_NAME_LENGTH;

public class CarName {

	private static final int CAR_NAME_MAX_LENGTH_LIMIT = 5;

	private final String name;

	public CarName(String name) {
		validateName(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validateName(String name) {
		if (checkNameIsEmpty(name) || checkNameOverMaxLength(name)) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
		}
	}

	private boolean checkNameIsEmpty(String name) {
		return name.isEmpty();
	}

	private boolean checkNameOverMaxLength(String name) {
		return name.length() > CAR_NAME_MAX_LENGTH_LIMIT;
	}
}
