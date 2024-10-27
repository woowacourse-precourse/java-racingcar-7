package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.MovementCondition;
import racingcar.service.SystemService;

import java.util.List;

public class CarController {
	private final MovementCondition movementCondition = new MovementCondition();
	private final SystemService systemService = new SystemService();

	private void carMovement(Car car) {
		movementCondition.movementBasedOnJudgment(car);
		systemService.printCarMovement(car);
	}

	public void carsMovement(List<Car> cars, int cnt) {
		for (int i = 0; i < cnt; i++) {
			cars.forEach(this::carMovement);
			System.out.println();
		}
	}

}
