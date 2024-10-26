package racingcar.io;

import java.util.List;

import racingcar.domain.car.Cars;
import racingcar.domain.race.RaceInfo;
import racingcar.validator.ValidatingParser;

public class IoHandler {
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final ValidatingParser validatingParser;

	private IoHandler(InputHandler inputHandler, OutputHandler outputHandler,
		ValidatingParser validatingParser) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.validatingParser = validatingParser;
	}

	public static IoHandler of(InputHandler inputHandler, OutputHandler outputHandler,
		ValidatingParser validatingParser) {
		return new IoHandler(inputHandler, outputHandler, validatingParser);
	}

	public RaceInfo handleRaceInfoForIo() {
		List<String> parsedCarNames = handleCarNames();
		int attemptCount = handleAttemptCount();
		return RaceInfo.of(parsedCarNames, attemptCount);
	}

	public void showResult() {
		outputHandler.promptGameResult();
	}

	public void showGameStatus(Cars cars) {
		outputHandler.promptGameStatus(cars);
	}

	public void showWinners(List<String> winners) {
		outputHandler.promptGameWinners(winners);
	}

	private List<String> handleCarNames() {
		outputHandler.promptForCarNames();
		String inputCarNames = inputHandler.inputCarNames();
		return validatingParser.parseValidatedCarNames(inputCarNames);
	}

	private int handleAttemptCount() {
		outputHandler.promptForAttemptCount();
		String inputAttemptCount = inputHandler.inputAttemptCount();
		return validatingParser.validateAttemptCount(inputAttemptCount);
	}

}
