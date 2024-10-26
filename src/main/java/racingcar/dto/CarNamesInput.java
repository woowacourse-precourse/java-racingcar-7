package racingcar.dto;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public record CarNamesInput(
	String carNames
) {
	public CarNamesInput {
		validateCarNamesNotNull(carNames);
		validateCarNamesEmpty(carNames);
	}

	private void validateCarNamesNotNull(String carNames) {
		if (carNames == null) {
			throw RacingCarGameException.from(ErrorMessage.NULL_INPUT_ERROR);
		}
	}

	private void validateCarNamesEmpty(String carNames) {
		if (carNames.isEmpty()) {
			throw RacingCarGameException.from(ErrorMessage.EMPTY_INPUT_ERROR);
		}
	}
}
