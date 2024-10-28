package racingcar.observer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import racingcar.CarGame;
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
        List<String> winnerNames = CarGame.getWinnersName(cars);
        try {
            writer.write(CarView.winnerNames(winnerNames));
            writer.flush();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
