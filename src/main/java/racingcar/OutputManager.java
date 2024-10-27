package racingcar;

import java.util.List;

public interface OutputManager {
    void printExecutionResult(List<Car> progressResult);
    void printWinner(List<Car> winner);
}
