package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import utils.NumberGenerator;

public class RacingGame {
	private final InputView inputView;
	private final OutputView outputView;
	private final NumberGenerator numberGenerator;

	public RacingGame() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.numberGenerator = new NumberGenerator();
	}

	public void play() {
		Cars cars = new Cars(inputView.readCarNames());
		int tries = inputView.readTries();

		playRounds(cars, tries);
		announceWinners(cars);
	}

	private void playRounds(Cars cars, int tries) {
		outputView.printGameStart();
		for (int i = 0; i < tries; i++) {
			cars.moveAll(numberGenerator);
			outputView.printRaceProgress(cars.getCars());
		}
	}

	private void announceWinners(Cars cars) {
		outputView.printWinners(cars.getWinners());
	}
}
