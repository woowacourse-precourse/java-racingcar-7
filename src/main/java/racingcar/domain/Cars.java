package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int findMaximumDistance() {
        sortByDistance();

        return cars.getFirst().getDistance();
    }

    private void sortByDistance() {
        this.cars.sort(Car::compareTo);
    }

    public List<Car> getCars() {
        return cars;
    }
}
