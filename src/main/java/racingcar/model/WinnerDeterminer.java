package racingcar.model;

import java.util.List;

public class WinnerDeterminer {

	private static final int MIN_MOVEMENT_VALUE = 0;

	private static List<String> getWinner(List<Car> cars, int maxMovementValue) {
		return cars.stream()
				.filter(car -> car.getMovement() == maxMovementValue)
				.map(Car::getName)
				.toList();
	}
}
