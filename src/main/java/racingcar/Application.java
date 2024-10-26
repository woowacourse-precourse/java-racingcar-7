package racingcar;

import racingcar.random.RandomNumberProvider;
import racingcar.io.InputHandler;
import racingcar.io.IoHandler;
import racingcar.io.OutputHandler;
import racingcar.validator.ValidatingParser;

public class Application {
	public static void main(String[] args) {
		RaceManager raceManager = RaceManager.of(
			IoHandler.of(InputHandler.create(), OutputHandler.create(), ValidatingParser.create()),
			RandomNumberProvider.create());

		raceManager.run();
	}
}
