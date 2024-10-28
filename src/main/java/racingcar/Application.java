package racingcar;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<Car> cars = InputView.inputCarNames();
		int tryCount = InputView.inputTryCount();

		RaceController raceController = new RaceController(cars, tryCount);
		raceController.runRace();
	}
}
