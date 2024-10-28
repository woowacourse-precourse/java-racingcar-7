package racingcar.service;

import racingcar.model.GameResult;
import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int tryCount;
    private final RandomMovementStrategy randomMovementStrategy;

    public RacingGame(List<RacingCar> racingCarList, RandomMovementStrategy randomMovementStrategy, int tryCount) {
        this.cars = racingCarList;
        this.tryCount = tryCount;
        this.randomMovementStrategy = randomMovementStrategy;
    }

    public GameResult play() {
        List<List<RacingCar>> gameProgress = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            playOneTurn();
            gameProgress.add(copyCurrentState());
        }

        return new GameResult(gameProgress, determineWinners());
    }

    private void playOneTurn() {
        for (RacingCar car : cars) {
            if (randomMovementStrategy.shouldMove()) {
                car.move();
            }
        }
    }

    private List<RacingCar> copyCurrentState() {
        return cars.stream()
            .map(RacingCar::copy)
            .collect(Collectors.toList());
    }

    private List<RacingCar> determineWinners() {
        int maxPosition = cars.stream()
            .mapToInt(RacingCar::getRaceResultLength)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getRaceResultLength() == maxPosition)
            .collect(Collectors.toList());
    }
}
