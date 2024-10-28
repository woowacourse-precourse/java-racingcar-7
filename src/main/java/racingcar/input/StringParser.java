package racingcar.input;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

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
        return new Car(name, 0);
    }
}
