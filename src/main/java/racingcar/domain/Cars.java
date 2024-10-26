package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] cars) {
        Arrays.asList(cars).stream()
                .map(Car::new)
                .forEach(this.cars::add);
    }
}
