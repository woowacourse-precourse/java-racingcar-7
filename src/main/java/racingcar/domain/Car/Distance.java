package racingcar.domain.Car;

public class Distance {
	private final static int INIT_DISTANCE = 0;
	private int value;

	public Distance() {
		this.value = INIT_DISTANCE;
	}

	public Distance(int value) {
		this.value = value;
	}
}
