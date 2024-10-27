package racingcar.racinggame.io.input;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.racinggame.io.input.validation.UserInputValidation;

public class InputHandler {

	private static final String CAR_NAME_DELIMITER = ",";
	private static final int SPLIT_OPTION = -1;

	private final UserInputValidation userInputValidation;

	public InputHandler(UserInputValidation userInputValidation) {
		this.userInputValidation = userInputValidation;
	}

	public List<String> getCarNames() {
		String inputCarNames = Console.readLine();
		userInputValidation.validateInputCarNames(inputCarNames, CAR_NAME_DELIMITER);

		return Arrays.asList(inputCarNames.split(CAR_NAME_DELIMITER, SPLIT_OPTION));
	}

	public int getTryCount() {
		String inputTryCount = Console.readLine();
		userInputValidation.validateTryCount(inputTryCount);

		return Integer.parseInt(inputTryCount);
	}
}
