package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 9;

	public int pick() {
		return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
	}
}