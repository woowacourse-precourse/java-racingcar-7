package racingcar.output;

import java.util.List;
import racingcar.car.Car;

public interface OutputManager {

    void displayPosition(List<Car> cars);

    void displayWinners(List<Car> winners);

    void displayError(String message);
}
