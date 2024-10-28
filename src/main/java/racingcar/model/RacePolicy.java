package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacePolicy {
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int CAR_MOVEMENT_THRESHOLD = 4;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }

    public boolean canMoveForward(int randomNumber) {
        return randomNumber >= CAR_MOVEMENT_THRESHOLD;
    }
}
