package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class CarPosition {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int FORWARD_CRITERIA = 3;
    private final int currentPosition;

    public CarPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public CarPosition updateCurrentPosition() {
        int forwardDistance = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END) - FORWARD_CRITERIA;

        return new CarPosition(this.currentPosition + Math.max(0, forwardDistance));
    }

    public boolean isAheadOrEqual(CarPosition carPosition) {
        return this.currentPosition >= carPosition.currentPosition;
    }

    public boolean isPosition(int givenPosition) {
        return this.currentPosition == givenPosition;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
