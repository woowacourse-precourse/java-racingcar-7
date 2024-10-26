package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarInputConverter {


    public static List<Car> setCarList(String[] carNames) {

        List<Car> participants = Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());

        return participants;
    }
}
