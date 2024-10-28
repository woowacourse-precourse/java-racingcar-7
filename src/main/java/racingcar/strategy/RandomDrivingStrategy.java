package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDrivingStrategy implements CarDrivingStrategy {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean driving() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_THRESHOLD;
    }
}