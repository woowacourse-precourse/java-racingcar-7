package racingcar;

import java.util.List;
import java.util.Arrays;

public class CarRacingGame {
    public static List<String> getCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }
}
