package racingcar.factory;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarFactory {

    public static List<Car> createCars(ArrayList<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
