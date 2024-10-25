package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;

public class RaceService {

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
