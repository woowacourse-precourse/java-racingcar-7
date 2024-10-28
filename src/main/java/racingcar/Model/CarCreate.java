package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

import racingcar.Util.Validator;

public class CarCreate {
    public static List<Car> createCar(List<String> carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (String name : carNames) {
            Validator.carName(name);
            cars.add(new Car(name));
        }
        return cars;
    }
}
