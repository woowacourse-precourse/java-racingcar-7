package racingcar.domain;

import java.util.List;
import racingcar.io.OutputWriter;
import racingcar.strategy.MoveStrategy;

public class Race {

    private List<Car> cars;
    private int attemptCount;
    private OutputWriter outputWriter;

    public Race(List<Car> cars, int attemptCount, OutputWriter outputWriter) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        this.outputWriter = outputWriter;
    }

    public void start(MoveStrategy moveStrategy) {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            round(moveStrategy);
            outputWriter.printRoundResult(cars);
        }
        outputWriter.printFinalWinner(cars);
    }

    private void round(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

}
