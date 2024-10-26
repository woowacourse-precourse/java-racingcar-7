package racingcar.domain;

import racingcar.Utils;

import java.util.List;

public class RacingGame {
    private final int limit;
    private final List<Car> participants;
    private final Utils utils = new Utils();

    public RacingGame(int limit, List<Car> participants) {
        this.limit = limit;
        this.participants = participants;
    }

    private void playSingleRound() {
        for (Car car : participants) {
            car.moveOrStop(utils.canMove());
        }
    }
}
