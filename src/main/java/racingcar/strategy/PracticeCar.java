package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class PracticeCar implements Mode {
    private static final Integer START_RANDOM_NUMBER = 0;
    private static final Integer END_RANDOM_NUMBER = 9;
    private static final Integer MOVEMENT_CRITERION_NUMBER = 8;

    private Integer racingCarMovementDistance = 0;

    @Override
    public void go() {
        if (IsNotRandomNumberLessThanCriterion()) {
            racingCarMovementDistance++;
        }
    }

    private boolean IsNotRandomNumberLessThanCriterion() {
        return getRandomNumber() >= MOVEMENT_CRITERION_NUMBER;
    }

    @Override
    public Integer getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }

    @Override
    public Integer getMovementDistance() {
        return racingCarMovementDistance;
    }

    @Override
    public void setMovementDistance(Integer movementDistance) {
        this.racingCarMovementDistance = movementDistance;
    }
}
