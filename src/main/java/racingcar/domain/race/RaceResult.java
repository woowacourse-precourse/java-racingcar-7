package racingcar.domain.race;

import racingcar.domain.car.Car;
import java.util.List;
import java.util.ArrayList;

public class RaceResult {
	private final List<Car> cars;

	public RaceResult(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getWinners() {
		int maxPosition = cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car);
			}
		}
		return winners;
	}

}
