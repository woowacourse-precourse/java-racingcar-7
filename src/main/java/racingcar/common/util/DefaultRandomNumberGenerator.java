package racingcar.common.util;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
	public int generateNumber(int min, int max) {
		return Randoms.pickNumberInRange(min, max);
	}
}
