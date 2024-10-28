package racingcar.domain;

public class Game {
	public static final String TRY_COUNT_MUST_BE_POSITIVE_NUMBER = "시도 횟수는 양의 정수여야 합니다.";
	public static final String TRY_COUNT_MUST_BE_NUMBER = "시도 횟수는 숫자여야 합니다.";
	private int tryCounts;
	private Cars racers;

	private static void validateIsPositive(int value) {
		if (value < 0) {
			throw new IllegalArgumentException(TRY_COUNT_MUST_BE_POSITIVE_NUMBER);
		}
	}

	private static int validateIsNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(TRY_COUNT_MUST_BE_NUMBER);
		}
	}

	private Game(int tryCounts, Cars cars) {
		this.racers = cars;
		this.tryCounts = tryCounts;
	}

	public static Game fromInputAndCars(String input, Cars cars) {
		int counts = validateIsNumber(input);
		validateIsPositive(counts);
		return new Game(counts, cars);
	}
}
