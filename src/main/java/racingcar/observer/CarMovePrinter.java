package racingcar.observer;

import racingcar.car.Car;
import racingcar.output.OutputHandler;

public class CarMovePrinter implements CarObserver {

    private final OutputHandler outputHandler;

    public CarMovePrinter(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    @Override
    public void onMoved(Car car) {
        outputHandler.displayCarPosition(car);
    }
}