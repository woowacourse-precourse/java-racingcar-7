package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;

	private RandomNumberPicker() {

	}

	public static int pickNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}
}
