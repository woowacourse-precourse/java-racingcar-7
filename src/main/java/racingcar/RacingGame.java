package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.provider.NumberProvider;
import racingcar.provider.RandomNumberProvider;

public class RacingGame {

    private static final int MOVING_DISTANCE_EACH_TRIAL = 1;

    private final NumberProvider numberProvider = new RandomNumberProvider();

    public void tryMoveForward(List<Car> cars) {
        for (Car car : cars) {
            int value = numberProvider.getNumber();
            car.tryMoveForward(value, MOVING_DISTANCE_EACH_TRIAL);
        }
    }

}
