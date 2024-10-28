package racingcar.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class GameStatus {

    private Set<Car> cars = new LinkedHashSet<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Set<Car> getCar() {
        return cars;
    }


}
