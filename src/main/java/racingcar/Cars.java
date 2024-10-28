package racingcar;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void print() {
        cars.forEach(car -> {
            car.print();
            System.out.println();
        });
    }

    public void move() {
        cars.forEach(Car::move);
    }
}
