package racingcar.controller;

import static racingcar.common.Constants.INIT_NUMBER;

import racingcar.common.Constants;
import racingcar.domain.Car;
import racingcar.service.JudgmentCarName;
import racingcar.service.MovementCondition;
import racingcar.service.SystemService;

import java.util.List;

public class CarController {
	private static final CarController INSTANCE = new CarController();
	private final JudgmentCarName judgment = JudgmentCarName.getInstance();
	private final MovementCondition movementCondition = MovementCondition.getInstance();
	private final SystemService systemService = SystemService.getInstance();

	private CarController() {}

	public List<Car> separate(String carsName) {
		List<Car> cars = systemService.splitCarsString(carsName);

		if (judgment.duplicateCheck(cars)) {
			throw new IllegalArgumentException();
		}

		return cars;
	}

	private void carMovement(Car car) {
		movementCondition.movementBasedOnJudgment(car);
		systemService.printCarMovement(car);
	}

	public void carMovementProcess(List<Car> cars, int cnt) {
		for (int i = INIT_NUMBER; i < cnt; i++) {
			cars.forEach(this::carMovement);
			System.out.println();
		}
	}

	public void pickWinner(List<Car> cars) {
		systemService.printWinner(cars);
	}

	public static CarController getInstance() {
		return INSTANCE;
	}
}
