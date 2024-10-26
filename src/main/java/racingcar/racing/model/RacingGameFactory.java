package racingcar.racing.model;

import java.util.List;

public interface RacingGameFactory {
    RacingGame createGame(int allRound, List<Car> cars);

    List<Car> createCars(List<String> carNames);
}
