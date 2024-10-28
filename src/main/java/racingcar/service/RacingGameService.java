package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.util.InputValidator;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private RacingGame racingGame;

    public void initGame(List<String> carNames) {
        racingGame = new RacingGame(carNames);
    }

    public List<String> processCarNames(String carNamesInput) {

    }

    public void validateNumberOfAttempts() {

    }

    public void moveCars() {

    }

    public List<Car> getCars() {

    }

    public List<String> getWinners() {

    }

    private int getMaxPosition() {

    }

}