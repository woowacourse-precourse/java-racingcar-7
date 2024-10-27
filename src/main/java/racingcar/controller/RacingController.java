package racingcar.controller;

import java.util.List;

import racingcar.domain.Attempt;
import racingcar.domain.Car.Car;
import racingcar.domain.Car.CarNames;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputMessage;
import racingcar.view.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;

	public RacingController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		CarNames carNames = inputCarName();
		Attempt attempt = inputAttempt();
		List<Car> cars = registerCars(carNames);
		Race race = Race.from(attempt, cars);
	}

	private CarNames inputCarName() {
		outputView.print(OutputMessage.INPUT_CAR_NAME);
		String input = inputView.readLine();
		return CarNames.from(input);
	}

	private Attempt inputAttempt() {
		outputView.print(OutputMessage.INSERT_ATTEMPT);
		String input = inputView.readLine();
		return Attempt.from(input);
	}

	private List<Car> registerCars(CarNames carNames) {
		return carNames.toCars();
	}
}
