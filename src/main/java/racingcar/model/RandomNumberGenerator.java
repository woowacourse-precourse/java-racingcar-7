package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

	private final static int RANDOM_NUMBER_MIN_VALUE = 0;
	private final static int RANDOM_NUMBER_MAX_VALUE = 9;

	public static int generateRandomNumber() {
		return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_VALUE, RANDOM_NUMBER_MAX_VALUE);
	}
}
