package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private List<Car> cars = new ArrayList<>();
	private int maxMoveCounter = 0;

	public CarList(String[] names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public int getMaxMoveCounter() {
		return maxMoveCounter;
	}

	public void startRace() {
		for (Car car : cars) {
			int moveCounter = car.move();
			maxMoveCounter = Math.max(moveCounter, maxMoveCounter);
		}
	}
}
