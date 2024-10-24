package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.name.Names;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.view.InputView;

public class GameController {

	public void run() {
		Names carNames = InputView.inputCarNames();
		Cars cars = Cars.from(carNames.getNames());
		RacingGameCount count = InputView.inputRaceCount();
	}


}
