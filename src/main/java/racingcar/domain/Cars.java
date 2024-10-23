package racingcar.domain;

import java.util.Set;

/**
 *
 */

public class Cars {
    private final Set<Car> cars;

    public Cars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Car> getCars() {
        return cars;
    }


}
