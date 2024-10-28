package racingcar.output.process;

import racingcar.entity.Car;

import java.util.List;

public interface ProcessOutputHandler {
    void printFirstPhrase();
    void printHistory(List<Car> history);
}
