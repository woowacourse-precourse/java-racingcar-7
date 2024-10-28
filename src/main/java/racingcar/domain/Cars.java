package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }
}
