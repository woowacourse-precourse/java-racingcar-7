package racingcar.domain.racingGame;

import racingcar.domain.car.Cars;

public class RacingRecord {
	private final Cars cars;

	public RacingRecord(Cars cars) {
		this.cars = cars;
	}

	public Cars getCars() {
		return cars;
	}
}
