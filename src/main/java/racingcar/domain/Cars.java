package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.common.Random;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void tryMove(Random random) {
		cars
			.forEach(car -> car.tryMove(random));
	}

	public List<Car> getWinners(){
		int maxPosition = cars.stream()
			.mapToInt(car -> car.getPosition())
			.max()
			.orElse(0);

		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	public List<Car> getCurrentStatus() {
		return Collections.unmodifiableList(cars);
	}
}
