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

	private void move(Cars cars, Turn turn) {
		// 문자 출력

		int current_turn = 1;

		while (current_turn <= turn.getTurnCount()){
			cars.tryMove(random);
			Output.printCurrentCarsStatus(cars.getCurrentStatus());

			current_turn += 1;
		}
	}
}
