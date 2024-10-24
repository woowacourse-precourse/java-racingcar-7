package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.name.Name;
import racingcar.domain.name.Names;
import racingcar.view.InputView;

public class GameController {

	public void run() {
		Names carNames = InputView.inputCarNames();
		Cars cars = generateCars(carNames);
	}

	private Cars generateCars(Names carNames) {
		List<Name> names = carNames.getNames();

		List<Car> cars = names.stream().map(Car::new).toList();

		return new Cars(cars);
	}

}
