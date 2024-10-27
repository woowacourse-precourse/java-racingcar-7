package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames) {
            cars.add(makeCar(carName));
        }
        return cars;
    }

    private Car makeCar(String carName) {
        return new Car(carName);
    }
}
