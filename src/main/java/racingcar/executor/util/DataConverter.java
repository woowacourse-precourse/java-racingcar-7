package racingcar.executor.util;

import racingcar.entity.Car;

import java.util.Arrays;
import java.util.List;

public class DataConverter {
    public static List<Car> convertFromCarNameListToCar(String[] input) {;
        return Arrays.stream(input).map(Car::new).toList();
    }
}
