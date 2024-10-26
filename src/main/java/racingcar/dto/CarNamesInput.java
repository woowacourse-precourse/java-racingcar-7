package racingcar.dto;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public record CarNamesInput(
	String carNames
) {
	public CarNamesInput {
		validateCarNamesNotNull(carNames);
	}

	private void validateCarNamesNotNull(String carNames) {
		if (carNames == null) {
			throw RacingCarGameException.from(ErrorMessage.NULL_INPUT_ERROR);
		}
	}
}
