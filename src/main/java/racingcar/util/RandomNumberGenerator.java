package racingcar.util;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

	private RandomNumberGenerator() {
	}

	public static List<Integer> generateBy(int min, int max, int numberCount) {
		List<Integer> numbers = new ArrayList<>(numberCount);

		for (int i = 0; i < numberCount; i++) {
			numbers.add(Randoms.pickNumberInRange(min, max));
		}

		return numbers;
	}
}
