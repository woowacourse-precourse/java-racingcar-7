package racingcar.util;

public class RoundParser {
    public static int parse(String input) {
        InputValidator.validRound(input);
        return Integer.parseInt(input);
    }
}
