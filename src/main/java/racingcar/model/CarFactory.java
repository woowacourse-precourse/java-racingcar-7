package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.enums.Separator;

public class CarFactory {

    public static List<Car> createCars(String input) {
        return Arrays.stream(input.split(Separator.COMMA.getSeparator()))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
