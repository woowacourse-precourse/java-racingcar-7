package racingcar.domain.racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import racingcar.domain.enums.ValidationMsg;

public class RacingCar {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private static final int MIN_RAMDOM = 0;
	private static final int MAX_RAMDOM = 9;

	private String carName;
	private Integer carPosition;

	public RacingCar(String carName) {
		validateCarName(carName);
		this.carName = carName;
		this.carPosition = 0;
	}

	private void validateCarName(String carName) {
		if (carName == null || carName.isEmpty() || carName.length() == 0) {
			throw new IllegalStateException(ValidationMsg.EMPTY_TYPE.getValue());
		}
	}

	public String getCarName() {
		return carName;
	}

	public Integer getCarPosition() {
		return carPosition;
	}

	private void movingForwardRacingCar() {
		this.carPosition++;
	}

	public void movingForward() {
		if (Randoms.pickNumberInRange(MIN_RAMDOM, MAX_RAMDOM) >= MOVING_FORWARD) {
			this.movingForwardRacingCar();
		}
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
