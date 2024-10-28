package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingRule {
    private final int minNumber;
    private final int maxNumber;
    private final int minNumberToMove;

    public RacingRule(int minNumber, int maxNumber, int minNumberToMove) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.minNumberToMove = minNumberToMove;
    }

    public boolean permitToMove() {
        return isMovable(pickRandomNumber());
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }

    private boolean isMovable(int number) {
        return number >= minNumberToMove;
    }
}
