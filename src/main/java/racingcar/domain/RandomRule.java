package racingcar.domain;

import racingcar.utils.RandomNoGenarator;

public class RandomRule implements GameRule {
    public static final int MOVE_NUM = 4;

    @Override
    public boolean isMovable() {
        int randNo = RandomNoGenarator.getRandomNo();
        return randNo >= MOVE_NUM;
    }

}
