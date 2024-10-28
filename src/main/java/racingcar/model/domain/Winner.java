package racingcar.model.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
	public static List<Car> determineWinners(List<Car> cars) {
		int maxPosition = findMaxPosition(cars);
		return filterWinners(cars, maxPosition);
	}

	private static int findMaxPosition(List<Car> cars) {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow();
	}

	private static List<Car> filterWinners(List<Car> cars, int maxPosition) {
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}
}