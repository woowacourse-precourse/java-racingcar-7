package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        List<String> names = carNames.getCarNames();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
