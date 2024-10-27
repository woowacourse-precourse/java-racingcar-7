package racingcar.model.input;

public class NumberValidator {

	public static int validateTrialCountIsDigit(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
