package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.NumberGenerator;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final NumberGenerator numberGenerator;
    private final RacingGameView racingGameView;

    public RacingGameController(NumberGenerator numberGenerator, RacingGameView racingGameView) {
        this.numberGenerator = numberGenerator;
        this.racingGameView = racingGameView;
    }

    public void start() {
        List<String> carNames = racingGameView.getCarNames();
        int attemptCount = racingGameView.getAttemptCount();
        List<Car> cars = createCars(carNames);

        race(attemptCount, cars);

        List<String> winnerCarNames = getWinnerCarNames(cars);
        racingGameView.printWinner(winnerCarNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(numberGenerator, carName))
                .toList();
    }

    private void race(int tryCount, List<Car> cars) {
        racingGameView.printGameStartMessage();
        while (tryCount-- > 0) {
            cars.forEach(Car::tryMove);
            racingGameView.printCarPositions(cars);
        }
    }

    private List<String> getWinnerCarNames(List<Car> cars) {
        int winnerPosition = getWinnerPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toList();
    }

    private int getWinnerPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }
}
