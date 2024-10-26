package racingcar.io;

import static racingcar.io.constant.ErrorMessage.ATTEMPT_COUNT_MESSAGE;
import static racingcar.io.constant.ErrorMessage.GUIDE_MESSAGE;
import static racingcar.io.constant.ErrorMessage.INVALID_TRY_COUNT_MESSAGE;
import static racingcar.io.constant.ErrorMessage.INVALID_USER_INPUT_MESSAGE;
import static racingcar.io.constant.ErrorMessage.NOT_POSITIVE_NUMBER_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public static String readUserInput() {
        OutputManager.printMessage(GUIDE_MESSAGE);

        String input = Console.readLine();
        validateEmptyString(input);
        return input;
    }

    public static int readAttemptCount() {
        OutputManager.printMessage(ATTEMPT_COUNT_MESSAGE);

        int attemptCount = 0;

        try {
            String userInput = Console.readLine();
            attemptCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }

        validatePositiveNumber(attemptCount);
        return attemptCount;
    }

    private static void validateEmptyString(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_USER_INPUT_MESSAGE);
        }
    }

    private static void validatePositiveNumber(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void close() {
        Console.close();
    }
}
