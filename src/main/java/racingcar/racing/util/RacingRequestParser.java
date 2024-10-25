package racingcar.racing.util;

import java.util.Arrays;
import java.util.List;

public class RacingRequestParser {

    public static List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
    }
}
