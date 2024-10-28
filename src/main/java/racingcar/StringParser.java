package racingcar;

import java.util.Arrays;
import java.util.List;

public class StringParser {
	private static final String CAR_NAME_SEPARATOR = ",";

	public static List<String> parseCarNames(String input) {
		List<String> names = Arrays.asList(input.split(CAR_NAME_SEPARATOR, -1));
		Validator.validateCarNames(names);
		return names;
	}

	public static long parsePositiveNumber(String input) {
		long number;
		try {
			number = Long.parseLong(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT);
		}

		Validator.validatePositiveNumber(number);
		return number;
	}
}
