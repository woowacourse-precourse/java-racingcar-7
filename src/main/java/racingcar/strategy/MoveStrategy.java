package racingcar.strategy;

import racingcar.MoveEvent;

public interface MoveStrategy {
    MoveEvent moveOrStop();
}
