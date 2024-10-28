package racingcar.common.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsWrapper {
	private static final int MIN_LANGE = 0;
	private static final int MAX_LANGE = 9;

	public static int getInt() {
		return Randoms.pickNumberInRange(MIN_LANGE, MAX_LANGE);
	}
}
