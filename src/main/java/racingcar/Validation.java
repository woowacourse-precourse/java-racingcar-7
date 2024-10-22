package racingcar;

public class Validation {

	public static void validateCarNames(String[] carNames) {
		for (String carName : carNames) {
			if (carName.isEmpty() || carName.length() > 5) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static int validateTryCounts(String tryCounts) {
		int counts;
		try {
			counts = Integer.parseInt(tryCounts);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return counts;
	}
}
