package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.BlankInputException;
import racingcar.exception.CarNameFormatException;
import racingcar.exception.MaxRoundCountException;
import racingcar.exception.RoundNumberFormatException;

import java.util.regex.Pattern;

public class InputView {

    private static final String COMMA_DELIMITED_NAME_REGEX = "^[a-zA-Z0-9가-힣]+(,[a-zA-Z0-9가-힣]+)*$";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";
    private static final int ROUND_COUNT_THRESHOLD = 50;

    public static String inputCarNames() {
        String input = Console.readLine();
        validateNotBlank(input);
        validateCommaDelimitedNames(input);
        return input;
    }

    public static String inputRoundNumber() {
        String input = Console.readLine();
        validateNotBlank(input);
        validateRoundNumber(input);
        validateRoundCount(input);
        return input;
    }

    private static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new BlankInputException();
        }
    }

    private static void validateCommaDelimitedNames(String input) {
        if (!Pattern.matches(COMMA_DELIMITED_NAME_REGEX, input)) {
            throw new CarNameFormatException();
        }
    }

    private static void validateRoundNumber(String input) {
        if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new RoundNumberFormatException();
        }
    }

    private static void validateRoundCount(String input) {
        if (Integer.parseInt(input) > ROUND_COUNT_THRESHOLD || Integer.parseInt(input) == 0) {
            throw new MaxRoundCountException();
        }
    }
}
