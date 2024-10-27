package racingcar;

import racingcar.common.util.DefaultRandomNumberGenerator;
import racingcar.common.util.RandomNumberGenerator;
import racingcar.domain.controller.RaceController;
import racingcar.domain.service.RaceService;
import racingcar.domain.view.RaceView;

public class Application {
	public static void main(String[] args) {
		RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();
		RaceService raceService = new RaceService(randomNumberGenerator);
		RaceView raceView = new RaceView();
		RaceController controller = new RaceController(raceService, raceView);

		controller.run();
	}
}
