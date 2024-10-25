package racingcar.controller;

import java.util.List;
import racingcar.service.RaceService;
import racingcar.view.View;

public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void start() {
        List<String> carNames = View.getCarNames();
        int count = View.getCount();
        raceService.makeCars(carNames);
        for (int i = 0; i < count; i++) {
            View.showResult(raceService.startRace());
        }
        View.showFinalResult(raceService.getWinner());
    }
}
