package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public interface OutputView {
    void printMidTitle();
    void printMidResult(List<Car> cars);
    void printFinalResult(List<Car> cars);
}
