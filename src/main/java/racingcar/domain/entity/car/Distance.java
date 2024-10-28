package racingcar.domain.entity.car;

public class Distance {
	private static final String PRINT_RESULT_UNIT = "-";
	private static final int RESULT_INDEX = 1;
	private int value = 0;

	public Distance() {
	}

	public void forward() {
		value++;
	}

	public String[] insertResultSentence(String[] sentence) {
		sentence[RESULT_INDEX] = PRINT_RESULT_UNIT.repeat(value);
		return sentence;
	}
}
