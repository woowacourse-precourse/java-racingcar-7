package racingcar.domain.controller;

import java.util.List;

import racingcar.domain.service.RaceService;
import racingcar.domain.view.RaceView;

public class RaceController {

	private final RaceView raceView;
	private final RaceService raceService;

	public RaceController(RaceService raceService, RaceView raceView) {
		this.raceView = raceView;
		this.raceService = raceService;
	}

	public void run() {
		List<String> carNames = raceView.receiveCarNames();
		int lap = raceView.receiveRaceLap();

		raceService.addCars(carNames);

		raceView.startRace();
		for (int i = 0; i < lap; i++) {
			raceService.race();
			raceView.displayRaceProgress(raceService.getRaceStatus());
		}

		raceView.displayWinners(raceService.getWinners());
	}

}
