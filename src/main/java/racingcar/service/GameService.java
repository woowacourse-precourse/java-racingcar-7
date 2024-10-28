package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.RacingCarGame;

import java.util.List;

public class GameService {
    private CarFactory carFactory = CarFactory.getInstance();
    private static GameService instance = new GameService();

    private GameService() {}
    public static GameService getInstance() {
        return instance;
    }

    public void game(String carNames, int turn) {
        List<Car> cars = carFactory.createCars(carNames);
        RacingCarGame racingCarGame = RacingCarGame.getInstance(cars);
        racingCarGame.game(turn);
    }
}
