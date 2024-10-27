package racingcar.racer;

import java.util.ArrayList;
import java.util.List;
import racingcar.racer.car.Car;

public class RacerFactory {
    public List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
