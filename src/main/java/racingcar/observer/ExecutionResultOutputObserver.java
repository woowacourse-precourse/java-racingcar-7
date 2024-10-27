package racingcar.observer;

import racingcar.car.Car;
import racingcar.car.CarView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class ExecutionResultOutputObserver implements Observer{
    private final Car car;
    private final Writer writer;

    ExecutionResultOutputObserver(Car car, Writer writer) {
        this.car = car;
        this.writer = writer;
    }

    @Override
    public void notifyUpdate() {
        try {
            writer.write(CarView.executionResult(car));
            writer.flush();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static ExecutionResultOutputObserver stdOutput(Car car) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        return new ExecutionResultOutputObserver(car, writer);
    }
}
