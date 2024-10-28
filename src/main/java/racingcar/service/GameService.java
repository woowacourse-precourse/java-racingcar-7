package racingcar.service;

import racingcar.domain.*;
import racingcar.domain.Number;

public class GameService {
    private final Number number;
    private final GameRounds gameRounds;

    public GameService() {
        this.number = new Number();
        this.gameRounds = new GameRounds();
    }

    public Cars generateCarList(String inputString) {
        return new Cars(inputString);
    }

    public GameRounds startGame(Cars cars, int tryCount) {
        while (tryCount-- > 0) {
            playOneRound(cars);
        }
        return gameRounds;
    }

    private void playOneRound(Cars cars) {
        for (Car car : cars.getCarList()) {
            car.setDistance(number.getRandomNumber());
        }
        gameRounds.addGameRound(cars);
    }
}
