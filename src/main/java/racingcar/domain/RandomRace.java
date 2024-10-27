package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.value.MoveForward;

final class RandomRace {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private RandomRace() {
    }

    public static RandomRace init() {
        return new RandomRace();
    }

    public MoveForward createMoveForward() {
        final var movableValue = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

        return MoveForward.from(movableValue);
    }
}