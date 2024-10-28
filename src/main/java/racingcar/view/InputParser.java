package racingcar.view;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static String DELIMITER = ",";

    public static List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER));
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public static BigInteger parseMaxRound(String input) {
        InputValidator.validateMaxRound(input);
        return new BigInteger(input);
    }
}
