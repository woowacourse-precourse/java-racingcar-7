package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.RandomNumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveAll(RandomNumberGenerator randomNumberGenerator) {
		cars.forEach(car -> {
			if (randomNumberGenerator.generate() >= 4) {
				car.moveForward();
			}
		});
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	public List<String> getCurrentPositions() {
		return cars.stream()
			.map(Car::getCurrentPositionString)
			.collect(Collectors.toList());
	}
}
