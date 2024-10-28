package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;
import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService;
    private final RacingGameView racingGameView;

    public RacingGameController(RacingGameService racingGameService, RacingGameView racingGameView) {
        this.racingGameService = racingGameService;
        this.racingGameView = racingGameView;
    }

    public void start(int rounds) {
        for (int i = 0; i < rounds; i++) {
            racingGameService.raceOnce();
            racingGameView.printRaceStatus(racingGameService.getCars());
        }
        List<String> winners = racingGameService.getWinners();
        racingGameView.printWinners(winners);
    }
}