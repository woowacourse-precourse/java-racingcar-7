package racingcar.domain;

import static racingcar.exception.ErrorMessage.*;

import racingcar.config.RaceConfig;

public class Name {
	private final String name;

	protected Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		validateNotBlank(name);
		validateLength(name);
		validateAlphabet(name);
	}

	private void validateNotBlank(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_BLANK.getMessage());
		}
	}

	private void validateLength(String name) {
		if (name.length() > RaceConfig.MAX_NAME_LENGTH.getNumber()) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEEDED.getMessage());
		}
	}

	private void validateAlphabet(String name) {
		if (!name.matches("^[a-zA-Z]+")) {
			throw new IllegalArgumentException(CAR_NAME_NOT_ALPHABET.getMessage());
		}
	}

	public String getName() {
		return name;
	}
}
