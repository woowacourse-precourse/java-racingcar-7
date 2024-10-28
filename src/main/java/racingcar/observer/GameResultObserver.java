package racingcar.observer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarView;

public class GameResultObserver implements Observer{
    private final List<Car> cars;
    private final Writer writer;

    public GameResultObserver(List<Car> cars, Writer writer) {
        this.cars = cars;
        this.writer = writer;
    }

    @Override
    public void notifyUpdate() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        List<String> names = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        try {
            writer.write(CarView.winnerNames(names));
            writer.flush();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
