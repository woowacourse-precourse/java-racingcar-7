package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.dto.RaceResultResponse;
import racingcar.util.RandomNumberPicker;

public class Cars {
	private final Set<Car> cars;

	public Cars(Set<Car> cars) {
		this.cars = cars;
	}

	public void moveEachCars() {
		cars.forEach(car -> car.move(RandomNumberPicker.pickNumber()));
	}

	public List<RaceResultResponse> findRaceStatus() {
		return cars.stream()
			.map(RaceResultResponse::new)
			.toList();
	}

	public Set<Car> selectWinners() {
		int maxDistance = findMaxDistance();

		return cars.stream()
			.filter(car -> car.getDistance() == maxDistance)
			.collect(Collectors.toUnmodifiableSet());
	}

	private int findMaxDistance() {
		return cars.stream()
			.mapToInt(Car::getDistance)
			.max()
			.orElse(0);
	}
}
