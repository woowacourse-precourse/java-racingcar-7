package racingcar.racing.view;

import static racingcar.racing.utils.ExceptionMessages.IO_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputConsole() {
        try {
            return Console.readLine().replace(" ", "");
        } catch (Exception e) {
            throw new IllegalArgumentException(IO_EXCEPTION_MESSAGE);
        }
    }
}
