package racingcar.io.domain;

import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars create(List<String> carNames) {

		List<Car> cars = carNames.stream()
			.map(Car::create)
			.toList();

		return new Cars(cars);
	}

}
