package racingcar.model.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
	private final List<Car> cars;

	public Race(List<Car> cars) {
		this.cars = List.copyOf(cars);
	}

	public void raceOnce() {
		cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
	}

	public List<Car> getCars() {
		return cars;
	}
}