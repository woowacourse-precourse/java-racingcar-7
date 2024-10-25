package racingcar.domain.car;

import java.util.List;

import racingcar.domain.name.Name;

public class Cars {
	private final List<Car> racingCars;

	public Cars(List<Car> cars) {
		this.racingCars = cars;
	}

	public static Cars from(List<Name> names) {
		List<Car> cars = names.stream().map(Car::new).toList();
		return new Cars(cars);
	}

	public List<Car> getRacingCars() {
		return racingCars;
	}
}
