package racingcar.util;

import racingcar.validator.Validator;

import java.util.Arrays;
import java.util.List;

import static racingcar.validator.Validator.*;

public class InputParser {

    public static List<String> splitCarNameString(String carNameString) {
        List<String> carNames = Arrays.stream(carNameString.split(",", -1))
                .map(String::trim)
                .peek(Validator::carNameStringNotNull)
                .peek(Validator::carNameLength)
                .toList();
        Validator.carNameDuplicated(carNames);

        return carNames;
    }

    public static int getIntRoundCount(String rountCountString) {
        roundCountStringNotNull(rountCountString);
        isRoundCountNumeric(rountCountString);
        final int roundCount = Integer.parseInt(rountCountString);
        roundCountPositive(roundCount);

        return roundCount;
    }
}
