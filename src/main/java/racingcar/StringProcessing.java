package racingcar;

import java.util.List;

public class StringProcessing {
    public static List<String> extractCarNames(String carNamesWithComa) {
        return List.of(carNamesWithComa.split(","));
    }
}
