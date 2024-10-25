package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Mode {
    private static final Integer START_RANDOM_NUMBER = 0;
    private static final Integer END_RANDOM_NUMBER = 9;
    private static final Integer MOVEMENT_CRITERION_NUMBER = 4;

    private Integer racingCarMovementDistance = 0;

    @Override
    public void go() {
        if (getRandomNumber() >= MOVEMENT_CRITERION_NUMBER) { //메서드 분리 필요
            racingCarMovementDistance++;
        }
    }

    private Integer getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }

    @Override
    public Integer getMovementDistance() {
        return racingCarMovementDistance;
    }
}