package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.GameSettings;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(GameSettings settings) {
        this.cars = new ArrayList<>();
        for (String carName : settings.getCarName()) {
            cars.add(new Car(carName));
        }
        this.attempts = settings.getAttemptCount();
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            OutputView.displayCarPositions(cars);
        }
        announceWinners();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void announceWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        OutputView.displayWinners(winners);
    }
}
