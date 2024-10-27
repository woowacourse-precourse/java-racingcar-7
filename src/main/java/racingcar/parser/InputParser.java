package racingcar.parser;

import racingcar.constant.GamePolicy;

public class InputParser {

    public String[] splitInput(String input) {
        return input.split(GamePolicy.INPUT_SEPARATOR);
    }

    public int parseInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }
}
