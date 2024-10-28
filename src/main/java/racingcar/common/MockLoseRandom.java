package racingcar.common;

public class MockLoseRandom implements Random{
	@Override
	public int pickRandomNumber() {
		return 3;
	}
}
