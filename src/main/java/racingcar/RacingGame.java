package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.provider.NumberProvider;
import racingcar.provider.RandomNumberProvider;

public class RacingGame {

    private final NumberProvider numberProvider = new RandomNumberProvider();

    public void forwardCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = numberProvider.getNumber();
            car.forward(randomNumber);
        }
    }

}
