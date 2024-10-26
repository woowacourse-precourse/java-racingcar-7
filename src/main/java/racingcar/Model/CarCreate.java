package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

import racingcar.View.Output;

public class CarCreate {
    public static List<Car> createCar(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (String name : carNames) {
            Output.validatorCarNames(name);
            cars.add(new Car(name));
        }
        return cars;
    }
}
