package racingcar.executor.decider.winner;

import racingcar.entity.Car;

import java.util.List;

public interface WinnerListDecider {
    List<String> findWinners(List<Car> history);
}
