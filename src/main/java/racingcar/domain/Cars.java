package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<CarName> carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> makeCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
