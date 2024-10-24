package racingcar.common.util;

public class Validator {

	public static void validLapCount(int lap) {
		if (lap <= 0) {
			throw new IllegalArgumentException(ErrorMessage.LAP_COUNT_ERROR.getMessage());
		}
	}

	public static void validateName(String name) {
		if (isInvalidName(name)) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
		}
	}

	private static boolean isInvalidName(String name) {
		return name == null || name.isEmpty() || name.length() > GameConstants.MAX_CAR_NAME_LENGTH || name.matches(
			GameConstants.EMPTY_INPUT_REGEX);
	}
}
