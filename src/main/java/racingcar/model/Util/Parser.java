package racingcar.model.Util;

import java.util.Arrays;
import java.util.List;

public final class Parser implements DelimiterSymbols {
    private final int limit = -1;

    public List<String> inputParser(String input) {
        String[] tokens = input.split(STANDARD_DELIMITER, limit);
        List<String> carNames = Arrays.asList(tokens);

        return carNames;
    }
}
