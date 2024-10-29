package racingcar.domain;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	public static final String TRY_COUNT_MUST_BE_POSITIVE_NUMBER = "시도 횟수는 양의 정수여야 합니다.";
	public static final String TRY_COUNT_MUST_BE_NUMBER = "시도 횟수는 숫자여야 합니다.";
	private Supplier<Integer> numberSupplier = () -> Randoms.pickNumberInRange(0, 9);
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

	private Game(Supplier<Integer> numberSupplier, int tryCounts, Cars racers) {
		this.numberSupplier = numberSupplier;
		this.tryCounts = tryCounts;
		this.racers = racers;
	}

	public static Game fromInputAndCars(String input, Cars cars) {
		int counts = validateIsNumber(input);
		validateIsPositive(counts);
		return new Game(counts, cars);
	}

	public static Game fromInputAndCarsWithSupplier(String input, Cars cars, Supplier<Integer> numberSupplier) {
		int counts = validateIsNumber(input);
		validateIsPositive(counts);
		return new Game(numberSupplier, counts, cars);
	}

	public void play(Consumer<String> printer) {
		IntStream.iterate(tryCounts, i -> i > 0, i -> --i)
			.forEach(value -> {
				printer.accept(racers.startRound(numberSupplier));
			});
	}

	public void printWinner(Consumer<String> printer) {
		printer.accept(racers.getWinner());
	}
}
