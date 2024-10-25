package racingcar.controller;

import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void raceStart() {
        String raceCarNames = InputView.inputRaceCarNames();
        String moveCount = InputView.inputMoveCount();
        Race race = raceService.doRace(raceCarNames,moveCount);
        String raceResult = race.getRaceResult();
        OutputView.printStr(raceResult);
    }
}
