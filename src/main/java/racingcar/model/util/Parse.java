package racingcar.model.util;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.domain.Car;
import racingcar.model.domain.Delimiter;

public class Parse {
	private final Delimiter delimiter;

	public Parse(Delimiter delimiter) {
		this.delimiter = delimiter;
	}


	public static int parseToInt(String attemptNumber) {
		return Integer.parseInt(attemptNumber);
	}

	public List<Car> parseToCar(String carNames) {
		return delimiter.splitCarNames(carNames).stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}
}