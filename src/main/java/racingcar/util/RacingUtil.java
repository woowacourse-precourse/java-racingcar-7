package racingcar.util;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingUtil {

    public static List<Car> getCarList(String input) {
        List<String> nameList = List.of(input.split(","));
        return nameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
