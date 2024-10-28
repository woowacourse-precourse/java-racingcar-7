package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.AttemptCountValidator;
import racingcar.validator.CarValidator;

public class InputView {

    public static String inputCarNames() {
        String carNames = Console.readLine();
        CarValidator.validateCarNames(carNames);
        return carNames;
    }

    public static int inputAttemptCount() {
        String input = Console.readLine();
        validateInputIsNumber(input);

        int attemptCount = Integer.parseInt(input);
        AttemptCountValidator.validateAttemptCount(attemptCount);

        return attemptCount;
    }

    private static void validateInputIsNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }
}
