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
        String attemptCount = Console.readLine();
        AttemptCountValidator.validateAttemptCount(toInt(attemptCount));
        return Integer.parseInt(attemptCount);
    }

    private static int toInt(String value) {
        if (!value.matches("[0-9]+")) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
        return Integer.parseInt(value);
    }
}
