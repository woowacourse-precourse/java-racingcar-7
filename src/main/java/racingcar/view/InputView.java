package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ErrorMessage;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static String inputCarName() {
        System.out.println(NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static int inputTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        final String input = Console.readLine();
        return getValidatedTryCount(input);
    }

    private static void validateTryCountInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private static int getValidatedTryCount(final String input) {
        validateTryCountInput(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}
