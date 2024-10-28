package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;

import racingcar.error.ErrorMessage;

public class Parser {

	public ArrayList<String> stringToList(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
		}
		return new ArrayList<>(Arrays.asList(input.split(",")));
	}

	public int stringToInt(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_RACE_COUNT.getMessage());
		}
		try {
			double value = Double.parseDouble(input);
			if (value % 1 != 0) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_RACE_COUNT.getMessage());
			}
			return (int) value;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_RACE_COUNT.getMessage());
		}
	}

}
