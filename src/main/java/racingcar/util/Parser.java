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
}
