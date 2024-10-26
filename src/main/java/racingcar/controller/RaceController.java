package racingcar.controller;

import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.OutputView;

public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public String doRace(String raceCarNames, String moveCount) {
        Race race = raceService.doRace(raceCarNames,moveCount);
        return OutputView.responseStr(raceService.getRaceResult(race));
    }
}
