package racingcar.observer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarView;


public class ExecutionResultOutputObserver implements Observer{
    private final List<Car> cars;
    private final Writer writer;

    public ExecutionResultOutputObserver(List<Car> cars, Writer writer) {
        this.cars = cars;
        this.writer = writer;
    }

    @Override
    public void notifyUpdate() {
        try {
            for (Car car: cars) {
                writer.write(CarView.executionResult(car));
            }
            writer.flush();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
