package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constant.Constant;

public class InputReader {

    private final InputParser inputParser;

    public InputReader(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public List<String> getNames() {
        String input = read();

        validateInputBlank(input);

        return inputParser.toList(input);
    }


    public int getTryCnt() {
        String number = read();

        validateInputBlank(number);
        validateNegative(number);

        return Integer.parseInt(number);
    }

    private String read() {
        String input = Console.readLine();
        Console.close();
        return input;
    }

    private void validateNegative(String number) {
        if (isNumber(number)) {
            throw new IllegalArgumentException(Constant.COUNT_ONLY_NATURAL_NUMBER_STRING);
        }
    }

    private void validateInputBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(Constant.INPUT_NULL_OR_EMPTY_STRING);
        }
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isNumber(String number) {
        return !number.matches(Constant.ONLY_NUMBER);
    }


}
