package racingcar;

import java.util.List;
import racingcar.domain.Car;

public class CarService {

    public void createCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
    }
}
