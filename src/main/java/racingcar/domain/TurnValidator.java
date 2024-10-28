package racingcar.domain;

public class TurnValidator {
	private static final int MINIMUM_TURN_COUNT = 1;

	public void validateTurn(int count) {
		if(count < MINIMUM_TURN_COUNT){
			throw new IllegalArgumentException("시도 횟수는 자연수만 가능합니다.");
		}
	}
}
