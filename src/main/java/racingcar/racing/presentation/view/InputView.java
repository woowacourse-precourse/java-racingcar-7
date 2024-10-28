package racingcar.racing.presentation.view;

import static racingcar.racing.common.ExceptionMessages.IO_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputConsole(String placeholder) {
        try {
            System.out.println(placeholder);
            return Console.readLine().replace(" ", "");
        } catch (Exception e) {
            throw new IllegalArgumentException(IO_EXCEPTION_MESSAGE);
        }
    }
}
