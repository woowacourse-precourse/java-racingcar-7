package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    private static final String NULL_INPUT_ERROR = "Null이 입력되었습니다.";
    private static final String EMPTY_INPUT_ERROR = "입력된 값이 없습니다.";

    public static String requestInput(String message) {
        System.out.println(message);

        return getInput();
    }

    private static String getInput() {
        try {
            String input = Console.readLine();
            validateInput(input);

            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR);
        }
    }

    private static void validateInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }
}
