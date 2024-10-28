package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.util.InputValidator;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class RacingGameService {

    private RacingGame racingGame;

    public List<Car> getCars() {
        return racingGame.getCars();
    }

    public List<String> getWinners() {

    }

    private int getMaxPosition() {

    }

    public void initGame(List<String> carNames) {
        racingGame = new RacingGame(carNames);
    }

    public List<String> processCarNames(String carNamesInput) {
        List<String> carNames = InputValidator.splitCarNames(carNamesInput);
        return carNames;
    }

    public void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("[error] 시도 횟수는 1 이상");
        }
    }

    public void moveCars() {
        for (Car car : racingGame.getCars()) {
            boolean shouldMove = RandomGenerator.shouldMove();
            car.move(shouldMove);
        }
    }
}