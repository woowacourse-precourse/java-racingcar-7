package racingcar;

import racingcar.domain.controller.RaceController;
import racingcar.domain.model.CarList;
import racingcar.domain.view.RaceView;

public class Application {
	public static void main(String[] args) {
		CarList carList = new CarList();
		RaceView raceView = new RaceView();
		RaceController raceController = new RaceController(carList, raceView);

		raceController.run();
	}
}
