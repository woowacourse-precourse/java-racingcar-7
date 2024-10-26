package racingcar;

import java.util.List;

public class InputExtractor {

    public static List<String> extractCarNames(String userInputCar) {

        String delimiter = ",";
        List<String> carNames = List.of(userInputCar.split(delimiter));

        return carNames;
    }
}
