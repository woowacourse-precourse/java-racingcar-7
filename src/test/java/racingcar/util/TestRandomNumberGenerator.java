package racingcar.util;

import racingcar.common.util.RandomNumberGenerator;

public class TestRandomNumberGenerator implements RandomNumberGenerator {

	private final int fixedNumber;

	public TestRandomNumberGenerator(int fixedNumber) {
		this.fixedNumber = fixedNumber;
	}

	@Override
	public int generateNumber(int min, int max) {
		return fixedNumber;
	}
}
