package racingcar.domain;

import java.util.List;

import racingcar.dto.RaceResultResponse;
import racingcar.dto.WinnerResponse;
import racingcar.util.RandomNumberPicker;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
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

	public List<WinnerResponse> selectWinners() {
		int maxDistance = findMaxDistance();

		return cars.stream()
			.filter(car -> car.getDistance() == maxDistance)
			.map(WinnerResponse::new)
			.toList();
	}

	private int findMaxDistance() {
		return cars.stream()
			.mapToInt(Car::getDistance)
			.max()
			.orElse(0);
	}
}
