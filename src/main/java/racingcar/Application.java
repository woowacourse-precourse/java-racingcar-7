package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.view.console.ConsoleInputView;
import racingcar.view.console.ConsoleOutputView;

public class Application {
	public static void main(String[] args) {
		RacingCarGameController racingCarGameController = new RacingCarGameController(
			new ConsoleInputView(),
			new ConsoleOutputView()
		);

		racingCarGameController.startGame();
	}
}
