package racingcar.observer;

import racingcar.Car;
import racingcar.OutputHandler;

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