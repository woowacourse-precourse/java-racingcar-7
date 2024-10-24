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
        final String input = read();

        validateInputBlank(input);
        return inputParser.toList(input);
    }


    public int getTryCnt() {
        final String number = read();

        validateInputBlank(number);
        validateNegative(number);
        return Integer.parseInt(number);
    }

    private String read() {
        final String input = Console.readLine();
        Console.close();
        return input;
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
