package racingcar.domain;

import java.util.List;

import racingcar.common.Random;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {
	private final Random random;

	public RacingGame(Random random) {
		this.random = random;
	}

	public void start() {
		Output.printRequestCarNames();
		List<String> carNames = Input.readCarNames();
		Cars cars = new Cars(carNames.stream().map(Car::new).toList());

		Output.printRequestTurnCount();
		Turn turn = new Turn(Input.readTurn());

		move(cars, turn);

		Winners winners = new Winners(cars.getWinners());

	}

	private void move(Cars cars, Turn turn) {
		Output.printExecutionResult();

		int current_turn = 1;

		while (current_turn <= turn.getTurnCount()){
			cars.tryMove(random);
			Output.printTotalCarCurrentStatus(cars.getCurrentStatus());

			current_turn += 1;
		}
	}
}
