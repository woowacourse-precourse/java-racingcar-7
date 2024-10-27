package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    String name;
    long moveCount;

    public RacingCar(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move() {
        // 움직일 수 있는 경우 : 무작위 숫자 4 이상
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moveCount++;
        };
    }

    public String getMoveCount() {
        return String.valueOf(moveCount);
    }
}
