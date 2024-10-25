package racingcar.racing.model;

import java.util.List;

public interface RacingGameFactory {
    Game createGame(int allStage);

    List<Car> createCars(List<String> carNames);

    Winner createWinner(Game game);
}
