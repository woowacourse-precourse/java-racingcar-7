package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {

    private CarCreator() {
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

}
