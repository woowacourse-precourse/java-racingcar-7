package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.RunMessage;

public class InputView {

    public static String inputCarNames() {
        System.out.print(RunMessage.INPUT_CAR.getMessage());
        return Console.readLine();
    }

    public static String inputAttemptCount() {
        System.out.print(RunMessage.INPUT_ATTEMPT_COUNT.getMessage());
        return Console.readLine();
    }
}
