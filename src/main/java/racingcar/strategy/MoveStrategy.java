package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

/** 자동차가 주행 전략을 제공하는 클래스 */
public final class MoveStrategy {

    private MoveStrategy() {}

    public static int random() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return 1;
        }
        return 0;
    }

}
