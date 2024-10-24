package racingcar;

public class Validation {

	private static final String WRONG_CAR_NAME_INPUT_MESSAGE = "올바르지 못한 자동차이름";
	private static final String WRONG_TRY_INPUT_MESSAGE = "올바르지 못한 시도 횟수";

	public static void validateCarNames(String[] carNames) {
		for (String carName : carNames) {
			if (carName.isEmpty() || carName.length() > 5) {
				throw new IllegalArgumentException(WRONG_CAR_NAME_INPUT_MESSAGE);
			}
		}
	}

	public static int validateTryCounts(String tryCounts) {
		int counts;
		try {
			counts = Integer.parseInt(tryCounts);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(WRONG_TRY_INPUT_MESSAGE);
		}
		if (counts <= 0) {
			throw new IllegalArgumentException(WRONG_TRY_INPUT_MESSAGE);
		}
		return counts;
	}
}
