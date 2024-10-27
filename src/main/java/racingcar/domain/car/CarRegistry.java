package racingcar.domain.car;

import java.util.HashSet;
import java.util.Set;

public class CarRegistry {
    private final Set<Car> cars;

    public CarRegistry(Set<Car> cars) {
        this.cars = new HashSet<>(cars);
    }

    public Set<Car> getCars() {
        return cars;
    }

}
