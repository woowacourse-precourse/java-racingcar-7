package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private static final String INVALID_USER_INPUT_MESSAGE = "빈 문자열을 입력할 수 없습니다.";
    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 1 부터 2147483647 까지의 정수값만 입력할 수 있습니다.";
    private static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "시도 횟수는 양수만 입력 가능합니다.";

    public static String readUserInput() {
        OutputManager.printGuideMessage();
        String input =  Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_USER_INPUT_MESSAGE);
        }
        return input;
    }

    public static int readTryCount() {
        OutputManager.printTryCountMessage();
        int tryCount = 0;
        try {
            String userInput = Console.readLine();
            tryCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }

        if (tryCount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
        return tryCount;
    }

    public static void close() {
        Console.close();
    }
}
