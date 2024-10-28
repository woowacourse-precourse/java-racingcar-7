package racingcar.domain;

import java.util.List;

import racingcar.common.Random;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {
	private final Random random;
	private final CarValidator carValidator;
	private final TurnValidator turnValidator;

	public RacingGame(Random random, CarValidator carValidator, TurnValidator turnValidator) {
		this.random = random;
		this.carValidator = carValidator;
		this.turnValidator = turnValidator;
	}

	public void start() {
		Output.printRequestCarNames();
		List<String> carNames = Input.readCarNames();
		Cars cars = new Cars(carNames.stream().map(name -> new Car(name, carValidator)).toList());

		Output.printRequestTurnCount();
		Turn turn = new Turn(Input.readTurn(), turnValidator);

		move(cars, turn);

		Winners winners = new Winners(cars.getWinners());
		Output.printWinners(winners.getWinners());
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
