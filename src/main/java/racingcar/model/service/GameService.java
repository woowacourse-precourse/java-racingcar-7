package racingcar.model.service;

import racingcar.model.domain.Cars;
import racingcar.model.domain.GameResult;

import java.util.Arrays;

public class GameService {

    private GameService() {
    }

    public static GameResult play(int playCnt, String carNames) {
        String[] names = carNames.split("\\s*,\\s*");
        Cars cars = Cars.from(Arrays.asList(names));
        GameResult gameResult = new GameResult();

        for (int i = 0; i < playCnt; i++) {
            cars = cars.moveForward();
            gameResult.recordRound(cars);
        }
        gameResult.recordWinner(cars);

        return gameResult;
    }
}