package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementStrategy implements CarStrategy {
    private static final Integer START_RANDOM_NUMBER = 0;
    private static final Integer END_RANDOM_NUMBER = 9;
    private static final Integer MOVEMENT_CRITERION_NUMBER = 4;

    @Override
    public boolean move() {
        return getRandomNumber() >= MOVEMENT_CRITERION_NUMBER;
    }

    private Integer getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }
}
