package racingcar.domain;

import java.util.List;

import racingcar.config.RaceConfig;
import racingcar.dto.CarMovementResponse;
import racingcar.dto.WinnerResponse;

public class Race {
	private final List<Car> cars;

	public Race(List<Car> cars) {
		this.cars = List.copyOf(cars);
	}

	public void moveEachCars(int randomNumber) {
		cars.forEach(car -> car.move(randomNumber));
	}

	public List<CarMovementResponse> findRaceResult() {
		return cars.stream()
			.map(CarMovementResponse::new)
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
			.orElse(RaceConfig.INITIAL_DISTANCE.getNumber());
	}
}
