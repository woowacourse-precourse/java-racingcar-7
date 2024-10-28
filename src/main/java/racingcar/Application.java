package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {
	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
		OutputHandler outputHandler = new OutputHandler();
		RacingCarMachine racingCarMachine = new RacingCarMachine(outputHandler, inputHandler);
		racingCarMachine.run();
	}
}
