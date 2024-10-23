package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private final int totalRaceTurn;

    public Race(int totalRaceTurn) {
        if (totalRaceTurn <= 0) {
            throw new IllegalArgumentException("자동차 경주는 1회 이상 진행되어야 합니다.");
        }
        this.totalRaceTurn = totalRaceTurn;
    }

    private static int pickRandomNumber() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber;
    }

    public static boolean moveForwardOrNot() {
        int pickedNumber = pickRandomNumber();

        if (pickedNumber >= 4) {
            return true;
        }
        return false;
    }
}
