package racingcar.view;

import static racingcar.model.parser.CarsParser.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ErrorMessage;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static String inputCarName() {
        System.out.println(NAME_INPUT_MESSAGE);
        final String input = Console.readLine();
        validate(input);
        return input;
    }

    public static String inputTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    private static void validate(final String carNames) {
        validateNonEmptyCarNames(carNames);
        validateCarCount(carNames);
    }

    private static void validateNonEmptyCarNames(final String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    private static void validateCarCount(final String carNames) {
        if (!carNames.contains(DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT.getMessage());
        }
    }
}
