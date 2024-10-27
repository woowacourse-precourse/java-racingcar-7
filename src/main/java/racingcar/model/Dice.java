package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {

    public Dice() {
    }

    public int roll() {
        // 0부터 9까지의 무작위 값 생성
        return Randoms.pickNumberInRange(0, 9);
    }
}
