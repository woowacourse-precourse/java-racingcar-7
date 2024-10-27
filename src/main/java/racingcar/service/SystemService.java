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

}
