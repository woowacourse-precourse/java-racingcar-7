package racingcar.view;

import racingcar.controller.CarController;
import racingcar.domain.Car;

import java.util.List;

public class Run {
	private final CarController controller = new CarController();

	public Run() {
		carProcess(Input.inputCarsName(), Input.inputCount());
	}

	public void carProcess(String carsName, int cnt) {
		List<Car> cars = controller.separate(carsName);
		controller.carMovementProcess(cars, cnt);
		controller.pickWinner(cars);
	}
}
