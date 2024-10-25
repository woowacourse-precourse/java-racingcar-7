package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    public static String printInputMessage(String message) {
        System.out.println(message);

        return getInput();
    }

    private static String getInput() {
        try {
            String input = Console.readLine();
            validateInput(input);

            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Null이 입력되었습니다.");
        }
    }

    private static void validateInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
    }
}
