package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

	@Override
	public boolean isMovable() {
		return Randoms.pickNumberInRange(0, 9) >= 4;
	}
}