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

	public List<Car> findTopOrderByPosition() {
		Integer top = cars.stream()
			.map(Car::getPosition)
			.max(Integer::compareTo)
			.orElseThrow(() -> new RuntimeException("위치 값이 존재하지 않습니다."));

		return cars.stream()
			.filter(car -> car.getPosition().equals(top))
			.toList();
	}

	public void clear() {
		cars.clear();
	}
}
