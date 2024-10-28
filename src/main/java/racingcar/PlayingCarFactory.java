package racingcar;

import java.util.*;

public class PlayingCarFactory {
    public static Set<Car> createCars(Set<String> carNames) {
        Set<Car> cars = new LinkedHashSet<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
