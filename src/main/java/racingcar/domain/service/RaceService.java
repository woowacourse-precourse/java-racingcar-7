package racingcar.domain.service;

import java.util.List;

import racingcar.common.util.ErrorMessage;
import racingcar.common.util.RandomNumberGenerator;
import racingcar.domain.model.Car;
import racingcar.domain.model.CarList;
import racingcar.domain.model.RaceStatus;

public class RaceService {

	private final RandomNumberGenerator randomNumberGenerator;
	private final CarList carList;

	public RaceService(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
		this.carList = new CarList();
	}

	public void addCars(List<String> names) {
		if (names == null || names.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.CAR_LIST_EMPTY_ERROR.getMessage());
		}
		names.forEach(name -> carList.addCar(new Car(name.trim())));
	}

	public void race() {
		carList.moveAll(randomNumberGenerator);
	}

	public List<RaceStatus> getRaceStatus() {
		return carList.getRaceStatus();
	}

	public String getWinners() {
		return carList.getWinners().orElse("");
	}

}
