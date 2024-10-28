package racingcar.printer;

import racingcar.domain.Car;

import java.util.List;

public interface Printer {

    void writeProgress(List<Car> cars);
    void printMessage(String message);
    void printProgress();
}
