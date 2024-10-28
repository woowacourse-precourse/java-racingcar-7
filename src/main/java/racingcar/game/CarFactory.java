package racingcar.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CarFactory {

    public static List<Car> createCars(final String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .map(CarFactory::validateName)
                .map(Car::new)
                .collect(Collectors.toList());

    }

    private static String validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다(" + name + ")");
        }
        return name;
    }
}
