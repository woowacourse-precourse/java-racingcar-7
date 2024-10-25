package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name,0,0));
        }

        return cars;
    }

}
