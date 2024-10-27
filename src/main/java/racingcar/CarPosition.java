package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class CarPosition {
    private int currentPosition;

    public CarPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void updateCurrentPosition() {
        int forwardDistance = Randoms.pickNumberInRange(0, 9) - 3;

        this.currentPosition += Math.max(0, forwardDistance);
    }

    public boolean isAheadOrEqual(CarPosition carPosition) {
        return this.currentPosition >= carPosition.currentPosition;
    }

    public boolean isPosition(int givenPosition) {
        return this.currentPosition == givenPosition;
    }

    public String toCustomFormatString(String customString) {
        return customString.repeat(this.currentPosition);
    }
}
