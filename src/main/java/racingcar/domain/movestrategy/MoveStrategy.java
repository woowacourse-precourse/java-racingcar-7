package racingcar.domain.movestrategy;

import racingcar.domain.Car;

public interface MoveStrategy {

    int MINIMUM_MOVE_CONDITION = 4;

    void move(Car car);
}
