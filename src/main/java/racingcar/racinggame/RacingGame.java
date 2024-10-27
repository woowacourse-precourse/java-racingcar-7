package racingcar.racinggame;

import java.util.List;

import racingcar.io.domain.Cars;
import racingcar.io.domain.RandomNumberGenerator;
import racingcar.io.input.InputHandler;
import racingcar.io.output.OutputHandler;

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
		outputHandler.showCarNamesInputComment();
		List<String> carNames = inputHandler.getCarNames();
		Cars cars = Cars.create(carNames);

		outputHandler.showTryCountInputComment();
		int tryCount = inputHandler.getTryCount();

		outputHandler.showResultComment();

		int carCount = cars.getCarCount();
		for (int i = 0; i < tryCount; i++) {
			List<Integer> randomNumbers = RandomNumberGenerator.generateBy(
				MIN_RANDOM_NUMBER,
				MAX_RANDOM_NUMBER,
				carCount);

			cars.moveAll(randomNumbers);
			outputHandler.showEachRound(cars);
		}

		List<String> winCarNames = cars.getWinners();
		outputHandler.showWinner(winCarNames);
	}

}
