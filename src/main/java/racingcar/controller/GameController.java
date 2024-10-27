package racingcar.controller;

import java.util.List;

import racingcar.model.car.Car;
import racingcar.model.input.NumberValidator;
import racingcar.model.ProgressResultGenerator;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.input.TextSeparator;
import racingcar.model.WinnerDeterminer;
import racingcar.model.WinnerResultGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void run() {
		String carNamesInput = getCarNamesInput();
		List<Car> cars = generateCars(carNamesInput);
		int trialCount = getTrialCountInput();
		executeRaceGame(cars, trialCount);
		printWinnerResultMessage(cars);
	}

	private String getCarNamesInput() {
		OutputView.printCarNamesInputMessage();
		return InputView.getInput();
	}

	private List<Car> generateCars(String carNamesInput) {
		List<String> carNames = TextSeparator.separateCarNames(carNamesInput);
		return carNames.stream()
				.map(Car::new)
				.toList();
	}

	private int getTrialCountInput() {
		OutputView.printTrialCountInputMessage();
		String trialCountInput = InputView.getInput();
		return NumberValidator.validateTrialCountIsDigit(trialCountInput);
	}

	private void executeRaceGame(List<Car> cars, int trialCount) {
		OutputView.printExecutionResultMessage();
		while(trialCount-- > 0) {
			executeRaceRound(cars);
			String progressResult = ProgressResultGenerator.generateProgressResult(cars);
			OutputView.printProgressResultMessage(progressResult);
		}
	}

	private void executeRaceRound(List<Car> cars) {
		cars.forEach(this::moveCar);
	}

	private void moveCar(Car car) {
		int randomNumber = RandomNumberGenerator.generateRandomNumber();
		car.move(randomNumber);
	}

	private void printWinnerResultMessage(List<Car> cars) {
		String winnerResult = generateWinnerResult(cars);
		OutputView.printWinnerResultMessage(winnerResult);
	}

	private String generateWinnerResult(List<Car> cars) {
		List<String> winners = WinnerDeterminer.determineWinner(cars);
		return WinnerResultGenerator.generateWinnerResult(winners);
	}
}
