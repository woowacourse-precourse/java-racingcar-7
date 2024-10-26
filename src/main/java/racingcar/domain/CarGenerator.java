package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
    public static List<Car> getParticipateCars(String input) {
        return Arrays.stream(input.replaceAll("\\s+", "")
                        .split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
