package racingcar.car.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import racingcar.car.domain.Car;

public class CarRepository {
	private final List<Car> cars;

	private CarRepository() {
		this.cars = new ArrayList<>();
	}

	private static class CarRepositoryHolder {
		private static final CarRepository INSTANCE = new CarRepository();
	}

	public static CarRepository getInstance() {
		return CarRepository.CarRepositoryHolder.INSTANCE;
	}

	public void saveAll(Collection<Car> cars) {
		this.cars.addAll(cars);
	}

	public List<Car> findAll() {
		return cars;
	}
}
