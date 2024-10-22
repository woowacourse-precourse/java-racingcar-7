package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition implements MoveCondition{

    @Override
    public boolean isMovable(RacingCarState racingCarState) {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }
}
