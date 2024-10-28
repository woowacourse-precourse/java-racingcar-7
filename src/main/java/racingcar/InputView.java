package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {

    }

    private static void validateInput(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    public static String readLine(final String printMessage) {
        System.out.println(printMessage);

        String input = Console.readLine();
        validateInput(input);

        return input;
    }
}
