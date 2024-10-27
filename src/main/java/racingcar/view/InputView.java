package racingcar.view;

import static racingcar.model.parser.CarsParser.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ErrorMessage;

public class InputView {
    private static final int ZERO = 0;
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static String inputCarName() {
        System.out.println(NAME_INPUT_MESSAGE);
        final String input = Console.readLine();
        validateCarNames(input);
        validateCarCount(input);
        return input;
    }

    public static int inputTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        final int tryCount = convertStringToInt(Console.readLine());
        validateTryCount(tryCount);
        return tryCount;
    }

    private static void validateCarNames(final String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    private static void validateCarCount(final String carNames) {
        if (!carNames.contains(DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT.getMessage());
        }
    }

    private static void validateTryCount(final int input) {
        if (input <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private static int convertStringToInt(final String input) {
        try {
            long value = Long.parseLong(input);
            checkOutOfIntegerRange(value);
            return (int) value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private static void checkOutOfIntegerRange(final long input) {
        if (input > Integer.MAX_VALUE || input < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
