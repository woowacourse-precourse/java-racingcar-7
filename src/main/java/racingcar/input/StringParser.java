package racingcar.input;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.exception.ErrorMessage;

public class StringParser {
    private static StringParser instance;

    private StringParser() {
    }

    public static StringParser getInstance() {
        if (instance == null) {
            instance = new StringParser();
        }

        return instance;
    }

    public List<Car> parse(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(String::trim)
                .map(this::createCar)
                .toList();
    }

    private Car createCar(String name) {
        validateCarName(name);
        return new Car(name, 0);
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_NAME_LENGTH.getValue());
        }
    }
}
