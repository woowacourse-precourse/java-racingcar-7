package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private static final String INVALID_USER_INPUT_MESSAGE = "빈 문자열을 입력할 수 없습니다.";

    public static String readUserInput() {
        OutputManager.printGuideMessage();
        String input =  Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_USER_INPUT_MESSAGE);
        }
        return input;
    }

    public static void close() {
        Console.close();
    }
}
