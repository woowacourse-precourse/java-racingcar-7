package racingcar.car;

import java.util.Arrays;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(String[] players) {
		validateDuplicateName(players);

		cars = Arrays.stream(players)
				.map(Car::new)
				.toList();
	}

	private void validateDuplicateName(String[] names) {
		long distinctNameCount = Arrays.stream(names)
				.map(String::trim)
				.distinct()
				.count();

		if (distinctNameCount != names.length) {
			throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
		}
	}
}
