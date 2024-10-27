package racingcar.random;

import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberProvider {
	private static final int START_NUMBER = 0;
	private static final int END_NUMBER = 9;

	private RandomNumberProvider() {
	}

	public static RandomNumberProvider create() {
		return new RandomNumberProvider();
	}

	public List<Integer> generateRandomNumbers(int carsCount) {
		return Stream.generate(() -> Randoms.pickNumberInRange(START_NUMBER, END_NUMBER))
			.limit(carsCount)
			.toList();
	}
}
