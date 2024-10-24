package racingcar;

import java.util.List;

public class Validator {
	public static void validateCarNames(List<String> carNames) {
		for (String name : carNames) {
			validateCarName(name);
		}
	}

	public static void validateCarName(String name) {
		if (name.isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException("Invalid name length");
		}
	}

	public static void validatePositiveNumber(long number) {
		if (number <= 0) {
			throw new IllegalArgumentException("Non-positive numbers cannot be entered");
		}
	}
}
