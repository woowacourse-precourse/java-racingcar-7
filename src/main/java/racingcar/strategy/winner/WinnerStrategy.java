package racingcar.strategy.winner;

import racingcar.domain.Car;

import java.util.List;

public interface WinnerStrategy {
    List<Car> determineWinners(List<Car> cars);
}