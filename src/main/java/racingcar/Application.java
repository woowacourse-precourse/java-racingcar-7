package racingcar;

import racingcar.racinggame.io.input.InputHandler;
import racingcar.racinggame.io.input.validation.UserInputValidation;
import racingcar.racinggame.io.output.OutputHandler;
import racingcar.racinggame.RacingGame;

public class Application {
	public static void main(String[] args) {

		InputHandler inputHandler = new InputHandler(new UserInputValidation());
		OutputHandler outputHandler = new OutputHandler();

		RacingGame racingGame = new RacingGame(inputHandler, outputHandler);
		racingGame.run();

	}
}
