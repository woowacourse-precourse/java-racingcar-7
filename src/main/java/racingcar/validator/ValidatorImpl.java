package racingcar.validator;

import static racingcar.constant.Letter.*;
import static racingcar.constant.Number.*;

public final class ValidatorImpl implements Validator {
	@Override
	public final String[] stringToArray(final String inputRacingCarNames) {
		validateCommaSeparatedInput(inputRacingCarNames);
		final String[] racingCarNameArr = inputRacingCarNames.split(COMMA.toString());
		validateMaxLengthForEachName(racingCarNameArr);
		return racingCarNameArr;
	}

	@Override
	public final long stringToLong(final String inputTryingCount) {
		validateNumericInputOnly(inputTryingCount);
		return Long.parseLong(inputTryingCount);
	}
	
	private final void validateCommaSeparatedInput(final String inputRacingCarNames) {
		if (!inputRacingCarNames.matches("^[\\w" + COMMA + "]+$")) {
			throw new IllegalArgumentException(COMMA + "로 이름을 구분할 수 있어야 합니다.");
		}
	}

	private final void validateMaxLengthForEachName(final String[] racingCarNameArr) {
		for (final String racingCarName : racingCarNameArr) {
			if (racingCarName.length() > MAX_LENGTH.get()) {
				throw new IllegalArgumentException("이름은 " + MAX_LENGTH + "자 이하만 가능합니다.");
			}
		}
	}

	private final void validateNumericInputOnly(final String inputTryingCount) {
		if (!inputTryingCount.matches("\\d+")) {
			throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
		}
	}
}
