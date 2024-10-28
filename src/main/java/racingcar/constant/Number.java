package racingcar.constant;

public enum Number {
	MAX_LENGTH(5),
	START(0),
	END(9),
	FORWARD_NUM(4);
	
	private final int number;
	
	Number(final int number) {
		this.number = number;
	}
	
	public int get() {
		return number;
	}
	
	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
