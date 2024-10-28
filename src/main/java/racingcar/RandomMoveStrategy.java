package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean shouldMove() {
        // TODO: 자동차가 전진할지 안할지 결정하는 함수. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

        return pickNumberInRange(0, 9) >= 4;
    }
}
