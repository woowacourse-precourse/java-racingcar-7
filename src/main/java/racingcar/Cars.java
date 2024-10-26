package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsFrom(String names) {
        List<Car> carList = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(carList);
    }

    public int size() {
        return cars.size();
    }
}
