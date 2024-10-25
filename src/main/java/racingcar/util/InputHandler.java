package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputHandler {

    public static String readCarNames() {
        Printer.print(SystemMessage.START_MESSAGE);
        return Console.readLine();
    }

    public static String readAttemptCount() {
        Printer.print(SystemMessage.ATTEMPT_COUNT_MESSAGE);
        return Console.readLine();
    }
}
