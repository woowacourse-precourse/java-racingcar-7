package racingcar.common;

public class MockWinRandom implements Random{
	@Override
	public int pickRandomNumber() {
		return 4;
	}
}
