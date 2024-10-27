package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.view.InputView;
import racingcar.view.OutputMessage;
import racingcar.view.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;

	public RacingController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		CarNames carNames = inputCarName();
	}

	private CarNames inputCarName() {
		outputView.print(OutputMessage.INPUT_CAR_NAME);
		String input = inputView.readLine();
		return CarNames.from(input);
	}
}
