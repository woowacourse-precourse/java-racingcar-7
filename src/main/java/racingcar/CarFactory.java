package racingcar;

import java.util.Arrays;

public class CarFactory {
    public static Cars createCars(String input) {
        return new Cars(Arrays.stream(input.split(",")).map(Car::new).toList());
    }
}
