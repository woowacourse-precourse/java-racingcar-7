package racingcar;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import racingcar.car.Car;
import racingcar.observer.ExecutionResultOutputObserver;
import racingcar.observer.GameResultObserver;
import racingcar.observer.Observer;

public class OutputObserverFactory {
    private static OutputObserverFactory instance = null;
    private final BufferedWriter bw;

    private OutputObserverFactory() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static OutputObserverFactory getInstance() {
        if (instance == null) {
            instance = new OutputObserverFactory();
        }
        return instance;
    }

    public Observer stdOutExecutionObserver(List<Car> cars) {
        return new ExecutionResultOutputObserver(cars, bw);
    }

    public Observer stdOutGameResultObserver(List<Car> cars) {
        return new GameResultObserver(cars, bw);
    }
}
