package racingcar.game;

import java.util.List;
import racingcar.car.Car;
import racingcar.view.OutputHandler;

public class RacingGame {
    private final OutputHandler outputHandler;
    private final List<Car> cars;
    private int rounds;

    public RacingGame(OutputHandler outputHandler, List<Car> cars, int rounds) {
        this.outputHandler = outputHandler;
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        while (rounds-- > 0) {
            cars.forEach(Car::move);
            outputHandler.printStatus(cars);
        }
        outputHandler.printWinner(getWinners());
    }

    private List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}
