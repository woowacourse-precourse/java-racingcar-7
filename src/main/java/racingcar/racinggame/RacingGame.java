package racingcar.racinggame;

import java.util.List;

import racingcar.racinggame.io.input.InputHandler;
import racingcar.racinggame.io.output.OutputHandler;
import racingcar.racinggame.race.TryCount;
import racingcar.racinggame.race.car.Cars;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {

	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;

	public RacingGame(InputHandler inputHandler, OutputHandler outputHandler) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
	}

	public void run() {
		Cars cars = createCarsFromUserInput();
		TryCount tryCount = getTryCountFromUerInput();

		raceAllRound(cars, tryCount);
		notifyWinner(cars);
	}

	private Cars createCarsFromUserInput() {
		outputHandler.showCarNamesInputComment();
		List<String> carNames = inputHandler.getCarNames();
		return Cars.create(carNames);
	}

	private TryCount getTryCountFromUerInput() {
		outputHandler.showTryCountInputComment();

		int tryCount = inputHandler.getTryCount();
		return TryCount.from(tryCount);
	}

	private void raceAllRound(Cars cars, TryCount tryCount) {
		outputHandler.showResultComment();

		int carCount = cars.getCarCount();
		for (int round = 0; round < tryCount.getCount(); round++) {
			raceEachRound(cars, carCount);
		}
	}

	private void raceEachRound(Cars cars, int carCount) {
		List<Integer> randomNumbers = RandomNumberGenerator.generateBy(
			MIN_RANDOM_NUMBER,
			MAX_RANDOM_NUMBER,
			carCount
		);

		cars.moveAll(randomNumbers);
		outputHandler.showEachRound(cars);
	}

	private void notifyWinner(Cars cars) {
		List<String> winCarNames = cars.getWinners();
		outputHandler.showWinner(winCarNames);
	}

}
