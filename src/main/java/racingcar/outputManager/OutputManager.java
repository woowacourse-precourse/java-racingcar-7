package racingcar.outputManager;

import java.util.List;
import racingcar.car.Car;

public interface OutputManager {
    void printExecutionResult(List<Car> progressResult);
    void printWinner(List<Car> winner);
}
