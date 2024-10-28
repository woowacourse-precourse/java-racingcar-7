package racingcar.controller;

import racingcar.model.domain.Delimiter;
import racingcar.model.service.RaceService;
import racingcar.view.InputView;

public class RaceController {
	private RaceService raceService;

	public void start() {
		String carNames = InputView.getCarNames();
		int attemptNumber = InputView.getAttemptNumber();

		this.raceService = new RaceService(Delimiter.COMMA, carNames, attemptNumber);
		raceService.runRace();
	}
}