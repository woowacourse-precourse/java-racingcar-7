package racingcar.domain;

public class TryNumber {
	private final int tryNumber;

	private TryNumber(int tryNumber) {
		this.tryNumber = tryNumber;
	}

	public static TryNumber from(int tryNumber) {
		return new TryNumber(tryNumber);
	}

	public boolean doesTryNumberNegative() {
		return tryNumber < 0;
	}

	public boolean isSameTryNumberZero() {
		return tryNumber == 0;
	}

	public int getTryNumber() {
		return tryNumber;
	}
}
