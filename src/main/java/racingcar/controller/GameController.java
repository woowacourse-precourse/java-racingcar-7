package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.NumberValidator;
import racingcar.model.TextSeparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void run() {
		OutputView.printCarNamesInputMessage();
		String carNamesInput = InputView.getCarNamesInput();
		List<String> carNames = TextSeparator.separateCarNames(carNamesInput);
		List<Car> cars = carNames.stream()
				.map(Car::new)
				.toList();
		OutputView.printTrialCountInputMessage();
		String trialCountInput = InputView.getTrialCountInput();
		int trialCount = NumberValidator.validateTrialCountIsDigit(trialCountInput);
		OutputView.printExecutionResultMessage();
		while(trialCount-- > 0) {
			executeRaceRound(cars);
		}
	}

	private void executeRaceRound(List<Car> cars) {
	}
}
