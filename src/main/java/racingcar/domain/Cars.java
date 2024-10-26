package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] cars) {
        Arrays.stream(cars)
                .map(Car::new)
                .forEach(this.cars::add);
    }

    public void racing(int moveNum) {
        IntStream.range(0, moveNum)
                .forEach(i -> {
                    cars.forEach(Car::moveOrStop);
                    printStatus();
                });
    }

    private void printStatus() {
        cars.forEach(Car::getStatus);
        System.out.println();
    }

    public Car getCar(int carNumber) {
        return cars.get(carNumber);
    }
}
