package racingcar.controller;

import java.util.List;

import racingcar.parser.CarNameInputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;

	public RacingController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		String carNameInput = readCarNameInput();
		List<String> carNames = parseCarNameInput(carNameInput);
	}

	private String readCarNameInput() {
		outputView.promptCarName();

		return inputView.readCarNameInput();
	}

	private List<String> parseCarNameInput(String carNameInput) {
		CarNameInputParser carNameInputParser = new CarNameInputParser();

		return carNameInputParser.parseInput(carNameInput);
	}
}
