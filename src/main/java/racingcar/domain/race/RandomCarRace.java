package racingcar.domain.race;

import racingcar.domain.move.MoveDecider;
import racingcar.domain.move.RandomMoveDecider;
import racingcar.randomGenerator.RandomDigitGenerator;

public class RandomCarRace extends CarRace {
    public static final RandomCarRace INSTANCE = new RandomCarRace(new RandomMoveDecider(RandomDigitGenerator.getInstance()));

    private RandomCarRace(MoveDecider moveDecider) {
        super(moveDecider);
    }

    public static RandomCarRace getInstance() {
        return INSTANCE;
    }
}
