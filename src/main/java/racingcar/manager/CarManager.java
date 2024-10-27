package racingcar.manager;

import static racingcar.util.RandomNumberGenerator.generateRandomNumber;

import java.util.Arrays;
import java.util.List;
import racingcar.entity.Car;

public class CarManager {

    public List<Car> carNamesToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    public void moveCars(List<Car> carList) {
        for (Car car : carList) {
            car.moveCar(generateRandomNumber());
        }
    }
}
