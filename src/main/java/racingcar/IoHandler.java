package racingcar;

import java.util.List;

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

	public GameInfo handleGameInfoForIo() {
		List<String> parsedCarNames = handleCarNames();
		int attemptCount = handleAttemptCount();
		return GameInfo.of(parsedCarNames, attemptCount);
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
