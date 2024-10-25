package racingcar.car.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.car.domain.Car;

public class CarRepository {
	private final Map<String, Car> cars;
	private CarRepository() {
		this.cars = new HashMap<>();
	}

	private static class CarRepositoryHolder {
		private static final CarRepository INSTANCE = new CarRepository();
	}

	public static CarRepository getInstance() {
		return CarRepository.CarRepositoryHolder.INSTANCE;
	}

	public void saveAll(List<Car> cars) {
		cars.forEach(car -> this.cars.put(car.getName(), car));
	}

	public List<Car> findAll() {
		return this.cars.values()
			.stream()
			.toList();
	}
}
