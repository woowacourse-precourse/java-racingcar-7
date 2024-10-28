package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.view.RequestView;
import racingcar.view.ResponseView;

public class RacingController {
	private final RequestView requestView;
	private final ResponseView responseView;
	private final RacingService racingService;

	public RacingController() {
		requestView = new RequestView();
		responseView = new ResponseView();
		racingService = new RacingService();
	}

	public void racing() {
		int tryCount = inputCarNamesAndTryCount();
		runRace(tryCount);
		displayWinners(tryCount);
		responseView.print();
	}

	private void displayWinners(int tryCount) {
		List<String> winnerNames = racingService.getWinnerNames(tryCount);
		responseView.addWinners(winnerNames);
	}

	private int inputCarNamesAndTryCount() {
		String carNames = requestView.inputCarNames();
		racingService.saveAll(carNames);
		return requestView.inputTryCount();
	}

	private void runRace(int tryCount) {
		while (racingService.canRacing(tryCount)) {
			List<Car> cars = racingService.race();
			responseView.addResult(cars);
		}
	}
}
