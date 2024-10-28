package racingcar.domain.racingcar;

import java.util.Objects;
import racingcar.domain.enums.ValidationMsg;

public class RacingCar {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private static final int MIN_RAMDOM = 0;
	private static final int MAX_RAMDOM = 9;

	private String carName;

	public RacingCar(String carName) {
		validateCarName(carName);
		this.carName = carName;
	}

	private void validateCarName(String carName) {
		if (carName == null || carName.isEmpty() || carName.length() == 0) {
			throw new IllegalStateException(ValidationMsg.EMPTY_TYPE.getValue());
		}
	}

	public String getCarName() {
		return carName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingCar racingCar = (RacingCar)o;
		return Objects.equals(carName, racingCar.carName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName);
	}
}
