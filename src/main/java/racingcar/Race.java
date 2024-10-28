package racingcar;

import java.util.List;
import racingcar.io.OutputHandler;

public class Race {

    private final List<Car> cars;
    private final int trialCount;
    private final MoveStrategy moveStrategy;
    private final OutputHandler outputHandler;

    public Race(List<Car> cars, int trialCount, MoveStrategy moveStrategy, OutputHandler outputHandler) {
        this.cars = cars;
        this.trialCount = trialCount;
        this.moveStrategy = moveStrategy;
        this.outputHandler = outputHandler;
    }

    public void startRace() {
        for (int i = 0; i < trialCount; i++) {
            moveCars();
            outputHandler.printTrialResult(cars);
        }
        outputHandler.printFinalWinner(getWinners());
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
