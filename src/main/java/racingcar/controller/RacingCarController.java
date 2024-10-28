package racingcar.controller;

import racingcar.domain.Race;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RacingCarController {
    private final Race race;
    private final RacingCarService racingCarService;
    private final RacingCarInputView racingCarInputView;
    private final RacingCarOutputView racingCarOutputView;


    public RacingCarController() {
        this.race = new Race();
        this.racingCarService = new RacingCarService();
        this.racingCarInputView = new RacingCarInputView();
        this.racingCarOutputView = new RacingCarOutputView();
    }

    public void run() {
        String[] racingCarNames = racingCarInputView.readRacingCarNameInput();
        int racingCarCount = racingCarInputView.readRacingCountInput();
        racingCarOutputView.printRacingCarResultMessage();
        racingCarService.createRace(race, racingCarNames);

        for (int round = 0; round < racingCarCount; round++) {
            racingCarService.updateRacingCarStatus(race);
            racingCarOutputView.printCurrentRacingCar(race);
        }
    }
}
