package racingcar.model.input;

import static racingcar.model.message.ErrorMessage.INVALID_TRIAL_COUNT;

public class NumberValidator {

	public static int validateTrialCountIsDigit(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_TRIAL_COUNT.getMessage());
		}
	}
}
