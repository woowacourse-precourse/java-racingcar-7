package racingcar.controller;

import racingcar.model.domain.Delimiter;
import racingcar.model.domain.Validator;
import racingcar.model.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
	private RaceService raceService;

	public void start() {
		runRace();
		runResult();
		displayWinners();
	}

	private void runRace() {
		String carNames = getCarNames();
		int attemptNumber = getAttemptNumber();
		this.raceService = new RaceService(Delimiter.COMMA, carNames, attemptNumber);
	}

	private String getCarNames() {
		OutputView.carName();
		String carNames = InputView.getCarNames();

		Validator.validateCarNames(carNames);
		return carNames;
	}

	private int getAttemptNumber() {
		OutputView.attemptNumber();
		int attemptNumber = InputView.getAttemptNumber();

		Validator.validateAttemptNumber(attemptNumber);
		return attemptNumber;
	}

	private void runResult() {
		OutputView.runResultGuide();
		raceService.runResult();
	}

	private void displayWinners() {
		OutputView.winners(raceService.getWinners());
	}
}