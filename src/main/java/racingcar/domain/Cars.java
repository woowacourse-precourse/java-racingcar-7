package racingcar.domain;

import java.util.Collections;
import java.util.List;

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

	public List<Car> getCurrentStatus() {
		return Collections.unmodifiableList(cars);
	}
}
