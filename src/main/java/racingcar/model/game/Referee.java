package racingcar.model.game;

import racingcar.model.car.Cars;

public interface Referee {
    Winners judgeWinners(Cars cars);
}
