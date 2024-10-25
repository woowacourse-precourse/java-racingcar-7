package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constant.Constant;

public class InputReader {

    private static final String ONLY_NUMBER = "^[1-9]\\d*$";

    private final InputParser inputParser;

    public InputReader(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public List<String> getNames() {
        final String input = Console.readLine();

        validateInputBlank(input);
        return inputParser.toList(input);
    }

    public int getTryCount() {
        final String number = Console.readLine();

        validateInputBlank(number);
        validateNegative(number);

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.COUNT_ONLY_INTEGER_NUMBER_STRING);
        }
    }

    private void validateNegative(final String number) {
        if (isNumber(number)) {
            throw new IllegalArgumentException(Constant.COUNT_ONLY_NATURAL_NUMBER_STRING);
        }
    }

    private void validateInputBlank(final String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(Constant.INPUT_NULL_OR_EMPTY_STRING);
        }
    }

    private boolean isBlank(final String input) {
        return input == null || input.isEmpty();
    }

    private boolean isNumber(final String number) {
        return !number.matches(ONLY_NUMBER);
    }


}
