package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputStringValidator;

public class ConsoleInputHandler {
    public String getUserInputCarNameString() {
        String userInputCarNameString = Console.readLine();
        InputStringValidator.carNameIsEmpty(userInputCarNameString);
        return userInputCarNameString;
    }

    public int getUserInputAttemptCount() {
        String userInputAttemptCount = Console.readLine();
        InputStringValidator.attemptCountIntegratedValidation(userInputAttemptCount);
        return Integer.parseInt(userInputAttemptCount);
    }
}
