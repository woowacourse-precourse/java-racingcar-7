package racingcar.controller;

import racingcar.model.domain.Delimiter;
import racingcar.model.domain.Validator;
import racingcar.model.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
	private RaceService raceService;

	public void start() {
		String carNames = InputView.getCarNames();
		Validator.validateCarNames(carNames);

		int attemptNumber = InputView.getAttemptNumber();
		Validator.validateAttemptNumber(attemptNumber);

		OutputView.raceResultGuide();
		this.raceService = new RaceService(Delimiter.COMMA, carNames, attemptNumber);
		raceService.runRace();

		OutputView.winners(raceService.getWinners());
	}
}