package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public boolean existByName(String name) {
		return repository.containsKey(name);
	}

	public List<Car> findAll() {
		return new ArrayList<>(repository.values());
	}

	public boolean existWinner(int tryCount) {
		return findAll().stream()
			.anyMatch(car -> car.isWinner(tryCount));
	}
}
