package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.Validator;

import java.util.List;

public abstract class InputHandler {

    public static List<String> readCarNames() {
        Printer.print(SystemMessage.START_MESSAGE);
        String carNames = Console.readLine();
        return Splitor.split(carNames).stream()
                .map(Validator::validateNameLength)
                .toList();
    }

    public static int readAttemptCount() {
        Printer.print(SystemMessage.ATTEMPT_COUNT_MESSAGE);
        String circleCount = Console.readLine();
        return Validator.validateCircleCountIfNegative(circleCount);
    }
}
