package racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int MOVING_DISTANCE_EACH_TRIAL = 1;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(String... carNames) {
        List<Car> carList = new ArrayList<>();

        for (String name : carNames) {
            carList.add(Car.from(name));
        }

        return Cars.from(carList);
    }

    public List<Car> findWinnerList() {
        Car winnerCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerCar))
                .toList();
    }
}
