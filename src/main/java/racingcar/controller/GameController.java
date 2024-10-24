package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void run() {
		OutputView.printCarNamesInputMessage();
		String carNamesInput = InputView.getCarNamesInput();
	}
}
