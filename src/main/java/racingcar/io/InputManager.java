package racingcar.io;

import static racingcar.io.ErrorMessage.INVALID_TRY_COUNT_MESSAGE;
import static racingcar.io.ErrorMessage.INVALID_USER_INPUT_MESSAGE;
import static racingcar.io.ErrorMessage.NOT_POSITIVE_NUMBER_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public static String readUserInput() {
        OutputManager.printGuideMessage();
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_USER_INPUT_MESSAGE);
        }
        return input;
    }

    public static int readAttemptCount() {
        OutputManager.printTryCountMessage();
        int attemptCount = 0;
        try {
            String userInput = Console.readLine();
            attemptCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }

        if (attemptCount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
        return attemptCount;
    }

    public static void close() {
        Console.close();
    }
}
