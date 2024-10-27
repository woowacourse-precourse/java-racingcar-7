package racingcar.race.racer;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class RacerUtils {
    public boolean isMovable(int randomNum) {
        if (0 <= randomNum && randomNum <= 3) {
            return false;
        } else if (4 <= randomNum && randomNum <= 9) {
            return true;
        } else {
            throw new RuntimeException("랜덤값이 0 ~ 9 범위를 벗어났습니다.");
        }
    }

    public int pickNumber(int minNum, int maxNum) {
        return Randoms.pickNumberInRange(minNum, maxNum);
    }
}
