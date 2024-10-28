package racingcar.domain;

public class Turn {
	private static final int ZERO = 0;
	private final int count;

	public Turn(int count) {
		validateTurn(count);
		this.count = count;
	}

	public int getTurnCount() {
		return count;
	}

	private void validateTurn(int count) {
		if(count <= ZERO){
			throw new IllegalArgumentException("시도 횟수는 자연수만 가능합니다.");
		}
	}
}
