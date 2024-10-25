package racingcar.service;

import racingcar.domain.car.Cars;
import racingcar.domain.name.Names;

public class CarService {
	public Cars generateCars(Names carNames) {
		return Cars.from(carNames.getNames());
	}
}
