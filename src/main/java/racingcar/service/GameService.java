package racingcar.service;

import racingcar.domain.*;
import racingcar.domain.RandomGenerator;

public class GameService {
    private final RandomGenerator randomGenerator;
    private final GameRounds gameRounds;

    public GameService() {
        this.randomGenerator = new RandomGenerator();
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
            car.setDistance(randomGenerator.getRandomNumber());
        }
        gameRounds.addGameRound(cars);
    }
}
