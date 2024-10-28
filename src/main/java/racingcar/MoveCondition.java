package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveCondition {

    // 이동 조건: 무작위 값이 4 이상일 때 전진
    public static boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }
}
