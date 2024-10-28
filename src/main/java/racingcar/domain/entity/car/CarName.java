package racingcar.domain.entity.car;

import java.util.Objects;

import racingcar.common.exception.ErrorMessages;
import racingcar.domain.vo.CarNameVO;

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

	public String[] createResultSentence() {
		String[] sentence = new String[2];
		sentence[0] = value;
		return sentence;
	}

	public CarNameVO toCarNameVO() {
		return new CarNameVO(value);
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
