package racingcar.domain.car;

import java.util.List;

import racingcar.domain.name.Name;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars from(List<Name> names) {
		List<Car> cars = names.stream().map(Car::new).toList();
		return new Cars(cars);
	}

	public int getNumberOfCars() {
		return cars.size();
	}
}
