package racingcar.racinggame;

import java.util.List;

import racingcar.racinggame.io.input.InputHandler;
import racingcar.racinggame.io.output.OutputHandler;
import racingcar.racinggame.race.car.Cars;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {

	private static final int MIN_TRY_COUNT = 1;
	private static final int MAX_TRY_COUNT = 10_000;
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final String OVER_FLOW_TRY_COUNT_RANGE = "시도 횟수가 지정된 범위를 벗어났습니다.";

	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;

	public RacingGame(InputHandler inputHandler, OutputHandler outputHandler) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
	}

	public void run() {
		Cars cars = createCarsFromUserInput();
		int tryCount = getTryCountFromUerInput();

		raceAllRound(cars, tryCount);
		notifyWinner(cars);
	}

	private Cars createCarsFromUserInput() {
		outputHandler.showCarNamesInputComment();
		List<String> carNames = inputHandler.getCarNames();
		return Cars.create(carNames);
	}

	private int getTryCountFromUerInput() {
		outputHandler.showTryCountInputComment();

		int tryCount = inputHandler.getTryCount();
		validateTryCountRange(tryCount);

		return tryCount;
	}

	private void validateTryCountRange(int tryCount) {
		if (tryCount < MIN_TRY_COUNT || MAX_TRY_COUNT < tryCount) {
			throw new IllegalArgumentException(OVER_FLOW_TRY_COUNT_RANGE);
		}
	}

	private void raceAllRound(Cars cars, int tryCount) {
		outputHandler.showResultComment();

		int carCount = cars.getCarCount();
		for (int i = 0; i < tryCount; i++) {
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
