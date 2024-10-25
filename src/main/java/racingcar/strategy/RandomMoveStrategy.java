package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 무작위 숫자로 진행 또는 멈춤을 정하는 전략
 */
public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public int getMovingDistance() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return 1;
        }
        return 0;
    }

}
