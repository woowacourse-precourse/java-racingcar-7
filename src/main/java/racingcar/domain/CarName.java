package racingcar.domain;

import java.util.Objects;

import racingcar.common.exception.ErrorMessages;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;
	private final String value;

	public CarName(String value) {
		validate(value);
		this.value = value;
	}

	private void validate(String value) {
		if (value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(ErrorMessages.OVER_MAX_LENGTH.getMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarName carName = (CarName)o;
		return Objects.equals(value, carName.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
