package racingcar.view.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RaceException;

public class Reader {

    public static String read() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        private static String validate(String input) {
            if (isBlank(input)) {
                throw new RaceException(ErrorMessage.INVALID_INPUT_BLANK);
            }
            return input;
        }

        private static boolean isBlank(String input) {
            return input.isBlank();
        }
    }
}
