package racingcar.service;

import racingcar.controller.CarController;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SystemService {

	public List<String> splitCarsString(String cars) {
		return Arrays.stream(cars.split(","))
				.map(String::trim)
				.collect(Collectors.toList());
	}

	public void printCarMovement(Car car) {
		System.out.print(car.getCarName() + " : ");

		for (int i = 0; i < car.getMovement(); i++) {
			System.out.print("-");
		}

		System.out.println();
	}

	public List<Car> getWinner(List<Car> cars) {
		int maxMovement = findMaxMovement(cars);

		return cars.stream()
				.filter(car -> car.getMovement() == maxMovement)
				.collect(Collectors.toList());
	}

	private int findMaxMovement(List<Car> cars) {
		return cars.stream()
				.mapToInt(Car::getMovement)
				.max()
				.orElse(0);
	}

}
