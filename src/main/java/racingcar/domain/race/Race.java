package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.view.OutputView;

import java.util.List;

public class Race {
	private final List<Car> cars;
	private final int raceCount;

	public Race(List<Car> cars, int raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public void moveCars() {
		for (Car car : cars) {
			car.move();
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}