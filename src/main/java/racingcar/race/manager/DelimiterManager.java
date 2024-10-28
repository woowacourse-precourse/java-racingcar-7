package racingcar.race.manager;

import java.util.Arrays;
import java.util.List;

public class DelimiterManager {
    private static final String CAR_NAME_DEFAULT_DELIMITER = ",";

    public List<String> splitByDefault(String names) {
        return Arrays.stream(
                        names.split(CAR_NAME_DEFAULT_DELIMITER)
                ).map(String::trim)
                .toList();
    }
}
