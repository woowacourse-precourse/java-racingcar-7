package racingcar.domain.movement;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.random_number.RandomNumber;

public class RandomMovementGenerator implements RandomMovement {

    public static final int RANDOM_MOVE_THRESHOLD = 4;
    private final RandomNumber randomNumber;

    public RandomMovementGenerator(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean canGo() {
        return randomNumber.generate() >= RANDOM_MOVE_THRESHOLD;
    }
}
