package racingcar.racing.util;

import java.util.Arrays;
import java.util.List;

public class RacingRequestParser {

    public static List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
    }

    public static Integer parseRound(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
