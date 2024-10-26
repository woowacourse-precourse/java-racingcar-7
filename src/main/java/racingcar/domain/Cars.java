package racingcar.domain;

import static racingcar.view.OutputView.printCurrentResult;

import java.util.List;
import racingcar.util.RandomGeneratorUtil;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = RandomGeneratorUtil.getRandomNumber();
            if (randomNumber >= 4) {
                car.movementOfNumber++;
            }
        }
        printCurrentResult(cars);

    }
}
