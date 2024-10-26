package racingcar.domain.car;

public class CarStatus {
	private final String carName;
	private final int moveDistance;

	private CarStatus(String carName, int moveDistance) {
		this.carName = carName;
		this.moveDistance = moveDistance;
	}

	public static CarStatus of(String carName, int moveDistance) {
		return new CarStatus(carName, moveDistance);
	}

	public String getCarName() {
		return carName;
	}

	public int getMoveDistance() {
		return moveDistance;
	}
}
