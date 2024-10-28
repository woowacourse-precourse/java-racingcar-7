package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class InputParser {

    private static final String DELIMITER = ",";

    public static List<Car> parseCars(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(name -> new Car(name.trim()))
                .toList();
    }

    public static int parseRoundCount(String roundCountStr) {
        return Integer.parseInt(roundCountStr.trim());
    }
}