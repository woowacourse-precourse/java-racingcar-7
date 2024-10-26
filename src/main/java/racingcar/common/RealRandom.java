package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class RealRandom implements Random{
	@Override
	public int pickRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}
}
