package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.JudgmentCarName;
import racingcar.service.MovementCondition;
import racingcar.service.SystemService;

import java.util.List;
import java.util.stream.Collectors;

public class CarController {
	private final JudgmentCarName judgment = new JudgmentCarName();
	private final MovementCondition movementCondition = new MovementCondition();
	private final SystemService systemService = new SystemService();

	public List<Car> separate(String carsName) {
		List<Car> cars = systemService.splitCarsString(carsName);

		if (duplicateCheck(cars)) {
			throw new IllegalArgumentException();
		}

		return cars;
	}

	private boolean duplicateCheck(List<Car> cars) {
		return judgment.judgmentCarNameDuplicate(cars.stream()
				.map(Car::getCarName)
				.collect(Collectors.toList()));
	}

	private void carMovement(Car car) {
		movementCondition.movementBasedOnJudgment(car);
		systemService.printCarMovement(car);
	}

	public void carMovementProcess(List<Car> cars, int cnt) {
		for (int i = 0; i < cnt; i++) {
			cars.forEach(this::carMovement);
			System.out.println();
		}
	}

	public void pickWinner(List<Car> cars) {
		systemService.printWinner(cars);
	}

}
