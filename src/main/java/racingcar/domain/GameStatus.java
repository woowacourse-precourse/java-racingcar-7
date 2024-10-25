package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

public class GameStatus {

    private Set<Car> cars = new HashSet<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Set<Car> getCar() {
        return cars;
    }




}
