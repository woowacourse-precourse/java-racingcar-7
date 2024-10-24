package racingcar.repository;

import java.util.HashMap;
import java.util.Map;

import racingcar.domain.Car;

public class CarRepository {
	private final Map<String, Car> repository;

	public CarRepository() {
		repository = new HashMap<>();
	}

	public void save(Car car) {
		repository.put(car.getName(), car);
	}
}
