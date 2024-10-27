package racingcar.domain;

import java.util.List;

import racingcar.util.RandomNumberPicker;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveEachCars() {
		cars.forEach(car -> car.move(RandomNumberPicker.pickNumber()));
	}

	public List<Car> selectWinners() {
		int maxDistance = findMaxDistance();

		return cars.stream()
			.filter(car -> car.getDistance() == maxDistance)
			.toList();
	}

	private int findMaxDistance() {
		return cars.stream()
			.mapToInt(Car::getDistance)
			.max()
			.orElse(0);
	}
}
