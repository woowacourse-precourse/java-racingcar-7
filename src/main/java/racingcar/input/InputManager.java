package racingcar.input;

import java.util.List;
import racingcar.car.Car;

public interface InputManager {

    List<Car> getCars();

    long getAttemptCount();
}
