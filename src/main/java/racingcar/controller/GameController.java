package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.NumberValidator;
import racingcar.model.ProgressResultGenerator;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.TextSeparator;
import racingcar.model.WinnerDeterminer;
import racingcar.model.WinnerResultGenerator;
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
			String progressResult = ProgressResultGenerator.generateProgressResult(cars);
			OutputView.printProgressResultMessage(progressResult);
		}
		List<String> winners = WinnerDeterminer.determineWinner(cars);
		String winnerResult = WinnerResultGenerator.generateWinnerResult(winners);
		OutputView.printWinnerResultMessage(winnerResult);
	}

	private void executeRaceRound(List<Car> cars) {
		cars.forEach(this::moveCar);
	}

	private void moveCar(Car car) {
		int randomNumber = RandomNumberGenerator.generateRandomNumber();
		car.move(randomNumber);
	}
}
