package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public interface RacingGame {

    void raceGame(List<Car> cars, int count);

    void playRound(List<Car> cars);

    List<String> findWinners(List<Car> cars);
}
