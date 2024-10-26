package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarFactory {
    public List<Car> createCars(StringTokenizer carNames) {
        List<Car> cars = new ArrayList<>();
        while (carNames.hasMoreTokens()) {
            cars.add(new Car(carNames.nextToken()));
        }
        return cars;
    }
}
