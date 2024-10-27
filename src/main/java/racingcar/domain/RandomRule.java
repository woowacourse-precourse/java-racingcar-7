package racingcar.domain;

import racingcar.utils.RandomNoGenarator;

public class RandomRule implements GameRule{

    @Override
    public boolean isMovable() {
        int randNo = RandomNoGenarator.getRandomNo();
        return randNo >= 4;
    }
}
